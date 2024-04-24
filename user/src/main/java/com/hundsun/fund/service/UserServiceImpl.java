package com.hundsun.fund.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hundsun.fund.exception.ServiceException;
import com.hundsun.fund.user.UserService;
import com.hundsun.fund.user.dto.SysEmployeeInfoDTO;
import com.hundsun.fund.user.dto.SysLoginDTO;
import com.hundsun.fund.user.dto.SysRegisterDTO;
import com.hundsun.fund.user.dto.SysUserInfoDTO;
import com.hundsun.fund.user.entity.Employee;
import com.hundsun.fund.user.entity.SysPermission;
import com.hundsun.fund.user.entity.SysRole;
import com.hundsun.fund.user.entity.SysUser;
import com.hundsun.fund.user.vo.EmployeeVO;
import com.hundsun.fund.user.vo.SysUserInfoVO;
import com.hundsun.fund.user.vo.SysUserVO;
import com.hundsun.fund.utils.Assert;
import com.hundsun.fund.utils.BcryptUtil;
import com.hundsun.fund.utils.JwtUtil;
import com.hundsun.fund.utils.RedisUtil;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.fund.mapper.EmployeeMapper;
import com.hundsun.fund.mapper.SysPermissionMapper;
import com.hundsun.fund.mapper.SysRoleMapper;
import com.hundsun.fund.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * @Date 2024/4/19 14:36
 * @Description
 */
@CloudComponent
@Slf4j
//注册、开户、信息管理、提供信息、登陆验证，token发放
public class UserServiceImpl implements UserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public SysUserVO userLogin(SysLoginDTO user) {
        SysUser verifyUser = sysUserMapper.selectByAccount(user.getAccount());
        // 验证账号密码
        Assert.isNull(verifyUser, 401, "账号不存在");
        Assert.state(!BcryptUtil.match(user.getPassword(), verifyUser.getPassword()), 401, "密码错误");
        // 验证账号状态
        Assert.state(verifyUser.getAccountStatus() == 2, 401, "账号已被冻结");
        Assert.state(verifyUser.getAccountStatus() == 3, 401, "账号已注销");
        Assert.notNull(redisUtil.hGet("token", verifyUser.getId().toString()), 401, "账号已在其他地方登录");

        try {
            //获得用户角色和权限
            List<SysRole> roles = sysRoleMapper.getUserRole(verifyUser.getId());
            List<SysPermission> permissions = sysPermissionMapper.getPermission(roles.stream().map(SysRole::getId).toArray(Long[]::new));
            String token = JwtUtil.sign(verifyUser.getId().toString(), roles, permissions);
            redisUtil.hPut("token", verifyUser.getId().toString(), token);
            //返回user信息和token
            return new SysUserVO(verifyUser.getId(),
                    verifyUser.getName(),
                    token);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServiceException(500, "登录失败");
        }
    }

    public EmployeeVO employeeLogin(SysLoginDTO employee) {
        Employee verifyEmployee = employeeMapper.selectOne(new QueryWrapper<Employee>().eq("account", employee.getAccount()));

        // 验证账号密码
        Assert.isNull(verifyEmployee, 401, "账号不存在");
        Assert.state(!BcryptUtil.match(employee.getPassword(), verifyEmployee.getPassword()), 401, "密码错误");
        Assert.notNull(redisUtil.hGet("token", verifyEmployee.getId().toString()), 401, "账号已在其他地方登录");


        try {
            //获得用户角色和权限
            List<SysRole> roles = sysRoleMapper.getEmployeeRole(verifyEmployee.getId());
            List<SysPermission> permissions = sysPermissionMapper.getPermission(roles.stream().map(SysRole::getId).toArray(Long[]::new));
            //返回user信息和token
            String token = JwtUtil.sign(verifyEmployee.getId().toString(), roles, permissions);
            redisUtil.hPut("token", verifyEmployee.getId().toString(), token);
            return new EmployeeVO(verifyEmployee.getId(),
                    verifyEmployee.getName(),
                    verifyEmployee.getPhoneNumber(),
                    verifyEmployee.getDepartment(),
                    token);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServiceException(500, "登录失败");
        }
    }

    @Transactional
    public SysUserVO userRegister(SysRegisterDTO user) {
        int riskProfile = 0;
        SysUser newUser = new SysUser(null, user.getAccount(), BcryptUtil.encode(user.getPassword()), user.getName(),
                user.getIdNumber(), user.getEmail(), user.getPhoneNumber(), user.getProvince(),
                user.getCity(), user.getAddress(), user.getOccupation(), user.getIndustry(), user.getWorkUnit(),
                user.getEducationalBackground(), user.getIsDishonest(), user.getCustomerType(), riskProfile,
                BcryptUtil.encode(user.getTransactionPassword()), 0, new Timestamp(System.currentTimeMillis()));
        sysUserMapper.insert(newUser);
        String token = JwtUtil.sign(user.getId().toString(),
                new ArrayList<SysRole>() {{
                    add(new SysRole(0L, "user", "普通用户"));
                }},
                new ArrayList<>());
        redisUtil.hPut("token", user.getId().toString(), token);
        //返回user信息和token
        return new SysUserVO(user.getId(),
                user.getName(),
                token);
    }


    public SysUserInfoVO getUserInfo(Long userId) {
        return sysUserMapper.getUserInfo(userId);
    }

    public Boolean updateEmployeeInfo(SysEmployeeInfoDTO employeeNewInfo) {
        return employeeMapper.updateEmployeeInfo(employeeNewInfo);
    }

    public Boolean updateUserInfo(SysUserInfoDTO userNewInfo) {
        return sysUserMapper.updateUserInfo(userNewInfo);
    }

    //登出，token失效
    public Boolean logout(Long userId, String token) {
        redisUtil.hDelete("token", userId.toString());
        redisUtil.sAdd("invalidtoken", token);
        return true;
    }

    public Boolean checkTransactionPassword(Long userId, String password) {
        String transactionPassword = sysUserMapper.getTransactionPassword(userId);
        if (transactionPassword == null) return false;
        return BcryptUtil.match(password, transactionPassword);
    }
}

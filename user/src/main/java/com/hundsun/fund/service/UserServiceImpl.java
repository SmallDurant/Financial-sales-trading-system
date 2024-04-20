package com.hundsun.fund.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hundsun.fund.user.dto.SysRegisterDTO;
import com.hundsun.fund.user.dto.SysLoginDTO;
import com.hundsun.fund.user.dto.SysUserInfoDTO;
import com.hundsun.fund.user.entity.Employee;
import com.hundsun.fund.user.entity.SysPermission;
import com.hundsun.fund.user.entity.SysRole;
import com.hundsun.fund.user.entity.SysUser;
import com.hundsun.fund.exception.ServiceException;
import com.hundsun.fund.mapper.EmployeeMapper;
import com.hundsun.fund.user.UserService;
import com.hundsun.fund.user.vo.EmployeeVO;
import com.hundsun.fund.utils.Assert;
import com.hundsun.fund.utils.BcryptUtil;
import com.hundsun.fund.utils.JwtUtil;
import com.hundsun.fund.user.vo.SysUserInfoVO;
import com.hundsun.fund.user.vo.SysUserVO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.fund.mapper.SysPermissionMapper;
import com.hundsun.fund.mapper.SysRoleMapper;
import com.hundsun.fund.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
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

    @Override
    //还未实现单点登录、登出后原token失效
    public SysUserVO userLogin(SysLoginDTO user) {
        SysUser verifyUser = sysUserMapper.selectByAccount(user.getAccount());
        // 验证账号密码
        Assert.isNull(verifyUser, 401, "账号不存在");
        Assert.state(!BcryptUtil.match(user.getPassword(), verifyUser.getPassword()), 401, "密码错误");
        // 验证账号状态
        Assert.state(verifyUser.getAccountStatus() == 2, 401, "账号已被冻结");
        Assert.state(verifyUser.getAccountStatus() == 3, 401, "账号已注销");

        try {
            //获得用户角色和权限
            List<SysRole> roles = sysRoleMapper.getUserRole(verifyUser.getId());
            List<SysPermission> permissions = sysPermissionMapper.getPermission(roles.stream().map(SysRole::getId).toArray(Long[]::new));
            //返回user信息和token
            return new SysUserVO(verifyUser.getId(),
                    verifyUser.getName(),
                    JwtUtil.sign(verifyUser.getId().toString(), roles, permissions));
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

        try {
            //获得用户角色和权限
            List<SysRole> roles = sysRoleMapper.getEmployeeRole(verifyEmployee.getId());
            List<SysPermission> permissions = sysPermissionMapper.getPermission(roles.stream().map(SysRole::getId).toArray(Long[]::new));
            //返回user信息和token
            return new EmployeeVO(verifyEmployee.getId(),
                    verifyEmployee.getName(),
                    verifyEmployee.getPhoneNumber(),
                    verifyEmployee.getDepartment(),
                    JwtUtil.sign(verifyEmployee.getId().toString(), roles, permissions));
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ServiceException(500, "登录失败");
        }
    }

    public SysUserVO userRegister(SysRegisterDTO user) {
        return null;
    }

    public SysUserInfoVO getUserInfo(Long userId) {
        return null;
    }

    public SysUserInfoVO updateUserInfo(SysUserInfoDTO userNewInfo) {
        return null;
    }

    //登出，token失效
    public boolean logout(String token) {
        return false;
    }
}

package com.hundsun.fund.user;

import com.hundsun.fund.user.user.dto.SysLoginDTO;
import com.hundsun.fund.user.user.dto.SysRegisterDTO;
import com.hundsun.fund.user.user.dto.SysUserInfoDTO;
import com.hundsun.fund.user.user.vo.EmployeeVO;
import com.hundsun.fund.user.user.vo.SysUserInfoVO;
import com.hundsun.fund.user.user.vo.SysUserVO;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

/**
 * @Author
 * @Date 2024/4/19 14:29
 * @Description
 */
@CloudService
public interface UserService {
    @CloudFunction("userLogin")
    SysUserVO userLogin(SysLoginDTO user);

    @CloudFunction("employeeLogin")
    EmployeeVO employeeLogin(SysLoginDTO employee);

    @CloudFunction("userRegister")
    SysUserVO userRegister(SysRegisterDTO user);

    @CloudFunction("getUserInfo")
    SysUserInfoVO getUserInfo(Long userId);

    @CloudFunction("updateUserInfo")
    boolean updateUserInfo(SysUserInfoDTO userNewInfo);

    @CloudFunction("logout")
    boolean logout(String token);
}

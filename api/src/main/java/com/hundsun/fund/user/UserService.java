package com.hundsun.fund.user;

import com.hundsun.fund.user.dto.SysEmployeeInfoDTO;
import com.hundsun.fund.user.dto.SysLoginDTO;
import com.hundsun.fund.user.dto.SysRegisterDTO;
import com.hundsun.fund.user.dto.SysUserInfoDTO;
import com.hundsun.fund.user.vo.EmployeeInfoVO;
import com.hundsun.fund.user.vo.EmployeeVO;
import com.hundsun.fund.user.vo.SysUserInfoVO;
import com.hundsun.fund.user.vo.SysUserVO;
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

    @CloudFunction("getEmployeeInfo")
    EmployeeInfoVO getEmployeeInfo(Long employeeId);

    @CloudFunction("updateUserInfo")
    Boolean updateUserInfo(SysUserInfoDTO userNewInfo);

    @CloudFunction("logout")
    Boolean logout(Long userId, String token);

    @CloudFunction("checkTransactionPassword")
    Boolean checkTransactionPassword(Long userId, String password);

    @CloudFunction("updateEmployeeInfo")
    Boolean updateEmployeeInfo(SysEmployeeInfoDTO employeeNewInfo);
}

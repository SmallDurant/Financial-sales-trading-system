package com.hunsun.fund.user;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.user.UserService;
import com.hundsun.fund.user.user.dto.SysLoginDTO;
import com.hundsun.fund.user.user.dto.SysRegisterDTO;
import com.hundsun.fund.user.user.dto.SysUserInfoDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import com.hunsun.fund.threadlocal.ThreadLocalUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2024/4/19 14:59
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @CloudReference
    private UserService userService;

    @RequestMapping("/test")
    public Result test(){
        return Result.success("yes");
    }

    @RequestMapping("/login")
    public Result login(@RequestBody SysLoginDTO user){
        return Result.success(userService.userLogin(user));
    }

    @RequestMapping("/register")
    public Result register(@RequestBody SysRegisterDTO user){
        return Result.success(userService.userRegister(user));
    }

    @RequestMapping("/logout")
    public Result logout(){
        return Result.success(userService.logout(ThreadLocalUtil.get("token")));
    }

    @RequestMapping("/getInfo")
    public Result getUserInfo(){
        return Result.success(userService.getUserInfo(Long.valueOf(ThreadLocalUtil.get("userId"))));
    }

    @RequestMapping("/updateInfo")
    @RequiresRoles("admin")
    public Result updateUserInfo(@RequestBody SysUserInfoDTO userInfo){
        userInfo.setId(Long.valueOf(ThreadLocalUtil.get("userId")));
        return Result.success(userService.updateUserInfo(userInfo));
    }

}

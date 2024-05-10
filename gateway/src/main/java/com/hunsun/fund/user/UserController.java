package com.hunsun.fund.user;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.user.dto.SysLoginDTO;
import com.hundsun.fund.user.UserService;
import com.hundsun.fund.user.dto.SysRegisterDTO;
import com.hundsun.fund.user.dto.SysUserInfoDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import com.hunsun.fund.threadlocal.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author
 * @Date 2024/4/19 14:59
 * @Description
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @CloudReference
    private UserService userService;


    @RequestMapping("/test")
    public Result test() {
        return Result.success("yes");
    }

    @RequestMapping("/login")
    public Result login(@RequestBody @Valid SysLoginDTO user) {
        return Result.success(userService.userLogin(user));
    }

    @RequestMapping("/register")
    public Result register(@RequestBody SysRegisterDTO user) {
        return Result.success(userService.userRegister(user));
    }

    @GetMapping("/info")
    public Result info(@RequestParam Long userId) {
        log.info("s");
        Set<String> roles = new HashSet<String>(ThreadLocalUtil.get("roles", List.class));
        if (roles.contains("user") && !userId.equals(Long.valueOf(ThreadLocalUtil.getEmployeeId())))
            return Result.error("无权限访问");
        return Result.success(userService.getUserInfo(userId));
    }

    @PostMapping("/info")
    public Result updateInfo(@RequestBody SysUserInfoDTO user) {
        return Result.state(userService.updateUserInfo(user));
    }

    @RequestMapping("/logout")
    public Result logout() {
        return Result.state(userService.logout(Long.valueOf(ThreadLocalUtil.getEmployeeId()),ThreadLocalUtil.get("token")));
    }

    @RequestMapping("/transaction")
   public Result checkTransactionPassword(String password){
        return Result.success(userService.checkTransactionPassword(Long.valueOf(ThreadLocalUtil.getEmployeeId()),password));
    }
}

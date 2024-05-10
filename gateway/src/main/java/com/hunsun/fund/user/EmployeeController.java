package com.hunsun.fund.user;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.user.UserService;
import com.hundsun.fund.user.dto.SysEmployeeInfoDTO;
import com.hundsun.fund.user.dto.SysLoginDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import com.hunsun.fund.threadlocal.ThreadLocalUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

/**
 * @Author
 * @Date 2024/4/23 17:05
 * @Description
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @CloudReference
    private UserService userService;

    @RequestMapping("/login")
    public Result login(@RequestBody @Valid SysLoginDTO sysLoginDTO) {
        return Result.success(userService.employeeLogin(sysLoginDTO));
    }

    @GetMapping("/info")
    public Result info(@RequestParam Long employeeId) {
        return Result.success(userService.getEmployeeInfo(employeeId));
    }

    @PostMapping("/info")
    public Result info(@RequestBody SysEmployeeInfoDTO sysEmployeeInfoDTO) {
        sysEmployeeInfoDTO.setId(Long.valueOf(ThreadLocalUtil.getEmployeeId()));
        return Result.state(userService.updateEmployeeInfo(sysEmployeeInfoDTO));
    }

    @RequestMapping("/logout")
    public Result logout() {
        return Result.success(userService.logout(Long.valueOf(ThreadLocalUtil.getEmployeeId()),ThreadLocalUtil.get("token")));
    }
}

package com.hunsun.fund.user;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.questionnaire.QuestionnaireService;
import com.hundsun.fund.user.dto.SysLoginDTO;
import com.hundsun.fund.user.UserService;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author
 * @Date 2024/4/19 14:59
 * @Description
 */
@RestController
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
}

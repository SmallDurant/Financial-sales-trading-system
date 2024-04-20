package com.hunsun.fund.exception;

import com.hundsun.fund.api.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @Author
 * @Date 2024/4/11 15:06
 * @Description
 */
@RestController
@Slf4j
public class GlobalExceptionController {

    ArrayList<String> message = new ArrayList<>();
    {
        message.add("token无效");
    }

    @RequestMapping("/exception/{code}/{message}")
    public Result exception(@PathVariable int code, @PathVariable int message){
        try {
           return Result.error(code,this.message.get(message));
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(500,"服务器内部错误");
        }
    }
}

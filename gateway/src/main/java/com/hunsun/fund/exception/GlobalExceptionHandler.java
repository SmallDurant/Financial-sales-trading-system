package com.hunsun.fund.exception;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.exception.ServiceException;
import com.hundsun.jrescloud.common.exception.BaseBizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author
 * @Date 2024/4/23 16:40
 * @Description
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handle(ServiceException se){
        return Result.error(se.getCode(),se.getMessage());
    }

    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    public Result handle(AuthorizationException ae) {
        return Result.error(403, "权限不足，无法访问");
    }

    @ExceptionHandler(BaseBizException.class)
    @ResponseBody
    public Result handle(BaseBizException be) {
        String message = be.getMessage();
        String[] messages = message.split("\r\n");
        String result = messages[0].replace("[-1][com.hundsun.fund.exception.ServiceException: ","");
        return Result.error(result);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        e.printStackTrace();
        log.error( e.getMessage(), e);
        return Result.error(400, "操作失败，请联系管理员");
    }
}

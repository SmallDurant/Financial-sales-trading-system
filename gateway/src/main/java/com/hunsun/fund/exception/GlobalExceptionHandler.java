package com.hunsun.fund.exception;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.exception.ServiceException;
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

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result handle(BindException be) {
        return Result.error(400, be.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        return Result.error(400, "操作失败，请联系管理员");
    }
}

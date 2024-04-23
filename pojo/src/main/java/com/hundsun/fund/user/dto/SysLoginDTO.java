package com.hundsun.fund.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author
 * @Date 2024/4/9 16:01
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysLoginDTO {
    @NotNull(message = "账号不能为空")
    private String account;
    @NotNull(message = "密码不能为空")
    private String password;
}

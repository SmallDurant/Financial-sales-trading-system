package com.hundsun.fund.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date 2024/4/9 16:01
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysLoginDTO {
    private String account;
    private String password;
}

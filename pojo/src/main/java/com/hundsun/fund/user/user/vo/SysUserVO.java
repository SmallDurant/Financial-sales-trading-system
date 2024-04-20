package com.hundsun.fund.user.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date 2024/4/19 15:03
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserVO {
    private Long id;
    private String username;
    private String token;
}

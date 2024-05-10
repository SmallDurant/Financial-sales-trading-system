package com.hundsun.fund.transaction.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: Dding
 * @date: 2024/04/25
 **/
@Data
public class UserInfoVO implements Serializable {

    // 用户名
    private String name;

    // 余额
    private BigDecimal balance;

    // 状态
    private Integer status;
}

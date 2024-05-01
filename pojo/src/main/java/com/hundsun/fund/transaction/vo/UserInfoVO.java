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

    private String name;

    private BigDecimal balance;

    private Byte status;
}

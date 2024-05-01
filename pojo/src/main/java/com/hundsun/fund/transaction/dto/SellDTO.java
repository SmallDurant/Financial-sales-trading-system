package com.hundsun.fund.transaction.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Data
public class SellDTO implements Serializable {
    // TODO: 待定义

    private Long accountId;
    private BigDecimal balance;
    private BigDecimal share;
}

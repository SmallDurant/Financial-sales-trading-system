package com.hundsun.fund.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellDTO implements Serializable {
    // TODO: 待定义

    private Long accountId;
    private BigDecimal balance;
    private BigDecimal share;
}

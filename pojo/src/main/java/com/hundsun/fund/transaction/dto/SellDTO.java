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

    // 客户账号ID
    Long account;

    // 交易的账号类型
    Long type;

    // 基金代码
    String fundCode;

    // 基金名称
    String fundName;

    // 赎回份额
    BigDecimal amount;
}

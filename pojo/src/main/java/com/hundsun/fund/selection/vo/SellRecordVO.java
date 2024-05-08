package com.hundsun.fund.selection.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: Dding
 * @date: 2024/04/17
 **/
@Data
public class SellRecordVO implements Serializable {

    // 基金ID
    private Long fundId;

    // 账户ID
    private Long accountId;

    // 客户ID
    private Long userId;

    // 购买金额
    private BigDecimal amount;
}

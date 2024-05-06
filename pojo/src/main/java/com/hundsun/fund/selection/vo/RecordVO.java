package com.hundsun.fund.selection.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: Dding
 * @date: 2024/04/17
 **/
@Data
public class RecordVO implements Serializable {
    // TODO: 待修改

    // 交易申请编号
    private Long requestId;

    // 用户ID
    private Long userId;

    // 账户ID
    private Long accountId;

    // 交易类型
    private Integer type;

    // 基金ID
    private Integer fundId;

    // 基金名称
    private String fundName;

    // 交易数量
    private BigDecimal amount;

    // 客户交易账号
    private String account;

    // 申请时间
    private LocalDateTime time;

    // 交易状态
    private Integer state;
}

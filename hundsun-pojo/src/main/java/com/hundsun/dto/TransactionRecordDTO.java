package com.hundsun.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author: Dding
 * @date: 2024/04/17
 **/
@Data
public class TransactionRecordDTO implements Serializable {

    // 客户交易账号
    private String account;

    // 基金代码
    private String fundCode;

    // 申请日期(起始)
    private LocalDate startDate;

    // 申请日期(终止)
    private LocalDate endDate;

    // 基金名称
    private String fundName;

    // 基金类型
    private Integer fundType;

    // 资金方式
    // private Integer chargeWay;
    // TODO: 是不是ui搞错了, 没有这个字段
}

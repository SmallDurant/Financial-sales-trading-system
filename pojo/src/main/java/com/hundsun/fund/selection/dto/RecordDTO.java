package com.hundsun.fund.selection.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: Dding
 * @date: 2024/04/17
 **/
@Data
public class RecordDTO implements Serializable {

    // 客户交易账号
    private Long accountId;

    // 基金代码
    private String fundCode;

    // 基金名称
    private String fundName;

    // 基金类型
    private Integer fundType;

    // 申请日期(起始)
    private LocalDateTime startDateTime;

    // 申请日期(终止)
    private LocalDateTime endDateTime;

}

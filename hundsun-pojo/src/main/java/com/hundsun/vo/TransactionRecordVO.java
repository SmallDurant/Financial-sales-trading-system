package com.hundsun.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: Dding
 * @date: 2024/04/17
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRecordVO implements Serializable {

    // 基金代码
    private String fundCode;

    // 客户交易账号
    private String account;

    // 客户类型
    private boolean customerType;

    // 客户名称
    private String name;

    // 交易申请编号
    private Integer requestId;

    // 申请时间
    private LocalDateTime time;
}

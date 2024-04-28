package com.hundsun.fund.log.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: Dding
 * @date: 2024/04/28
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogRecordVO implements Serializable {

    // 柜员id
    private Long EmployeeId;

    // 操作类型
    private Integer type;

    // 操作详情
    private String detail;

    // 操作时间
    private LocalDateTime time;
}

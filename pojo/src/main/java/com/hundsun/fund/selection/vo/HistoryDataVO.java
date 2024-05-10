package com.hundsun.fund.selection.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author: Dding
 * @date: 2024/05/01
 **/
@Data
public class HistoryDataVO {

    // 日期
    private LocalDate date;

    // 数量
    private Integer num;

}

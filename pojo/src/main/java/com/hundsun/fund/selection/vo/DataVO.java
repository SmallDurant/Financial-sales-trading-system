package com.hundsun.fund.selection.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: Dding
 * @date: 2024/05/06
 **/
@Data
public class DataVO {

    Integer confirmedNum;

    Integer unconfirmedNum;

    Integer buyNum;

    Integer sellNum;

    Integer cancelNum;

    Integer fundNum;

    List<HistoryDataVO> BuyHistoryNum;

    List<HistoryDataVO> SellHistoryNum;

    List<HistoryDataVO> CancelHistoryNum;
}

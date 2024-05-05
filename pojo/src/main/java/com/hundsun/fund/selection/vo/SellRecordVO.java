package com.hundsun.fund.selection.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Dding
 * @date: 2024/04/17
 **/
@Data
public class SellRecordVO implements Serializable {

    // 基金ID
    private String fundId;

    // 客户ID
    private String userId;

}

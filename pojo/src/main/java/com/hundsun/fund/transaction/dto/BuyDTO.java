package com.hundsun.fund.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyDTO {

    //购买金额
    private Double amount;
}

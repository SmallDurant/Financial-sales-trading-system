package com.hundsun.fund.selection.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: Dding
 * @date: 2024/04/29
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortionVO implements Serializable {

    // 用户id
    private Long userId;

    // 账户id
    private Long accountId;

    // 基金id
    private Long fundId;

    // 持有份额
    private BigDecimal portion;

    // 冻结份额
    private BigDecimal frozenPortion;

}

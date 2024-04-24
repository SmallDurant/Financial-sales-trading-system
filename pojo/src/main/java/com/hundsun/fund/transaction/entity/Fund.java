package com.hundsun.fund.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author: Dding
 * @date: 2024/04/17
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fund implements Serializable {
    /**
     * 字段描述和说明详见word->表(汇总)
     */
    // 基金ID(主键)
    private Integer fundId;

    // 基金代码(唯一确定)
    private String fundCode;

    private String fundName;

    private String fundAdministrator;

    private String fundTrustee;

    private String fundIssuer;

    private LocalDate effectiveDate;

    // 0-股票基金, 1-债券基金, 2-混合基金, 3-货币基金
    private Integer fundType;

    private String transactionCurrency;

    // 0-5对应R0-R5
    private Integer fundRisk;

    // 1-4表示申购赎回暂停和开放的排列组合
    private Integer fundStatus;

    // 0-前端收费, 1-后端收费, 2-前后端收费
    private Integer chargeWay;

    private BigDecimal purchaseRate;

    private BigDecimal redemptionRate;

    private BigDecimal managementFeeRate;

    private BigDecimal custodianFeeRate;

    private BigDecimal fundSize;

    private BigDecimal establishmentScale;

    private BigDecimal fundShares;

    private Integer minPurchaseAmount;

    private BigDecimal nav;

    private BigDecimal cnav;

    private String investmentPhilosophy;

    private String investmentScope;

    private String investmentStrategy;

    private String operationMode;

    private Integer fundStage;

    // 默认为false
    private Boolean isDelete = false;

}

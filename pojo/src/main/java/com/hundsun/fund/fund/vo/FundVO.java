package com.hundsun.fund.fund.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: Dding
 * @date: 2024/04/16
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FundVO implements Serializable {

    private Long fundId;

    private String fundCode;

    private String fundName;

    private String fundAdministrator;

    private String fundTrustee;

    private String fundIssuer;

    private Date effectiveDate;

    private Byte fundType;

    private String transactionCurrency;

    private Byte fundRisk;

    private Byte fundStatus;

    private Byte chargeWay;

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

    private Byte fundStage;

    private Boolean isDelete;

}

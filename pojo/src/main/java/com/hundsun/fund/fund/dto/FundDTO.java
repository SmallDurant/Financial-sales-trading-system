package com.hundsun.fund.fund.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class FundDTO implements Serializable {

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

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundAdministrator() {
        return fundAdministrator;
    }

    public void setFundAdministrator(String fundAdministrator) {
        this.fundAdministrator = fundAdministrator;
    }

    public String getFundTrustee() {
        return fundTrustee;
    }

    public void setFundTrustee(String fundTrustee) {
        this.fundTrustee = fundTrustee;
    }

    public String getFundIssuer() {
        return fundIssuer;
    }

    public void setFundIssuer(String fundIssuer) {
        this.fundIssuer = fundIssuer;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Byte getFundType() {
        return fundType;
    }

    public void setFundType(Byte fundType) {
        this.fundType = fundType;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public Byte getFundRisk() {
        return fundRisk;
    }

    public void setFundRisk(Byte fundRisk) {
        this.fundRisk = fundRisk;
    }

    public Byte getFundStatus() {
        return fundStatus;
    }

    public void setFundStatus(Byte fundStatus) {
        this.fundStatus = fundStatus;
    }

    public Byte getChargeWay() {
        return chargeWay;
    }

    public void setChargeWay(Byte chargeWay) {
        this.chargeWay = chargeWay;
    }

    public BigDecimal getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(BigDecimal purchaseRate) {
        this.purchaseRate = purchaseRate;
    }

    public BigDecimal getRedemptionRate() {
        return redemptionRate;
    }

    public void setRedemptionRate(BigDecimal redemptionRate) {
        this.redemptionRate = redemptionRate;
    }

    public BigDecimal getManagementFeeRate() {
        return managementFeeRate;
    }

    public void setManagementFeeRate(BigDecimal managementFeeRate) {
        this.managementFeeRate = managementFeeRate;
    }

    public BigDecimal getCustodianFeeRate() {
        return custodianFeeRate;
    }

    public void setCustodianFeeRate(BigDecimal custodianFeeRate) {
        this.custodianFeeRate = custodianFeeRate;
    }

    public BigDecimal getFundSize() {
        return fundSize;
    }

    public void setFundSize(BigDecimal fundSize) {
        this.fundSize = fundSize;
    }

    public BigDecimal getEstablishmentScale() {
        return establishmentScale;
    }

    public void setEstablishmentScale(BigDecimal establishmentScale) {
        this.establishmentScale = establishmentScale;
    }

    public BigDecimal getFundShares() {
        return fundShares;
    }

    public void setFundShares(BigDecimal fundShares) {
        this.fundShares = fundShares;
    }

    public Integer getMinPurchaseAmount() {
        return minPurchaseAmount;
    }

    public void setMinPurchaseAmount(Integer minPurchaseAmount) {
        this.minPurchaseAmount = minPurchaseAmount;
    }

    public BigDecimal getNav() {
        return nav;
    }

    public void setNav(BigDecimal nav) {
        this.nav = nav;
    }

    public BigDecimal getCnav() {
        return cnav;
    }

    public void setCnav(BigDecimal cnav) {
        this.cnav = cnav;
    }

    public String getInvestmentPhilosophy() {
        return investmentPhilosophy;
    }

    public void setInvestmentPhilosophy(String investmentPhilosophy) {
        this.investmentPhilosophy = investmentPhilosophy;
    }

    public String getInvestmentScope() {
        return investmentScope;
    }

    public void setInvestmentScope(String investmentScope) {
        this.investmentScope = investmentScope;
    }

    public String getInvestmentStrategy() {
        return investmentStrategy;
    }

    public void setInvestmentStrategy(String investmentStrategy) {
        this.investmentStrategy = investmentStrategy;
    }

    public String getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(String operationMode) {
        this.operationMode = operationMode;
    }

    public Byte getFundStage() {
        return fundStage;
    }

    public void setFundStage(Byte fundStage) {
        this.fundStage = fundStage;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
    @Override
    public String toString() {
        return "FundInfo{" +
                "fundId=" + fundId +
                ", fundCode='" + fundCode + '\'' +
                ", fundName='" + fundName + '\'' +
                ", fundAdministrator='" + fundAdministrator + '\'' +
                ", fundTrustee='" + fundTrustee + '\'' +
                ", fundIssuer='" + fundIssuer + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", fundType=" + fundType +
                ", transactionCurrency='" + transactionCurrency + '\'' +
                ", fundRisk=" + fundRisk +
                ", fundStatus=" + fundStatus +
                ", chargeWay=" + chargeWay +
                ", purchaseRate=" + purchaseRate +
                ", redemptionRate=" + redemptionRate +
                ", managementFeeRate=" + managementFeeRate +
                ", custodianFeeRate=" + custodianFeeRate +
                ", fundSize=" + fundSize +
                ", establishmentScale=" + establishmentScale +
                ", fundShares=" + fundShares +
                ", minPurchaseAmount=" + minPurchaseAmount +
                ", nav=" + nav +
                ", cnav=" + cnav +
                ", investmentPhilosophy='" + investmentPhilosophy + '\'' +
                ", investmentScope='" + investmentScope + '\'' +
                ", investmentStrategy='" + investmentStrategy + '\'' +
                ", operationMode='" + operationMode + '\'' +
                ", fundStage=" + fundStage +
                ", isDelete=" + isDelete +
                '}';
    }

}

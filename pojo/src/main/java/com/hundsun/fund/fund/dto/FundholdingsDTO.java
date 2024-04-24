package com.hundsun.fund.fund.dto;

import java.math.BigDecimal;

public class FundholdingsDTO {

    private Long id;
    private Long userId;
    private Long accountId;
    private Long fundId;
    private BigDecimal portion;
    private BigDecimal frozenPortion;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public BigDecimal getPortion() {
        return portion;
    }

    public void setPortion(BigDecimal portion) {
        this.portion = portion;
    }

    public BigDecimal getFrozenPortion() {
        return frozenPortion;
    }

    public void setFrozenPortion(BigDecimal frozenPortion) {
        this.frozenPortion = frozenPortion;
    }

    @Override
    public String toString() {
        return "TportionDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", accountId=" + accountId +
                ", fundId=" + fundId +
                ", portion=" + portion +
                ", frozenPortion=" + frozenPortion +
                '}';
    }
}

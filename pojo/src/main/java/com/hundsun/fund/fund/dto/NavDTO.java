package com.hundsun.fund.fund.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NavDTO {
    private Long id; // 主键，自增
    private Long fundId; // 基金ID
    private LocalDate date; // 日期
    private BigDecimal nav; // 单位净值
    private BigDecimal cnav; // 累计净值

    // 默认构造器
    public NavDTO() {
    }

    // 带所有参数的构造器
    public NavDTO(Long id, Long fundId, LocalDate date, BigDecimal nav, BigDecimal cnav) {
        this.id = id;
        this.fundId = fundId;
        this.date = date;
        this.nav = nav;
        this.cnav = cnav;
    }

    // Getter和Setter方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    // toString 方法，用于简便的打印和查看对象信息
    @Override
    public String toString() {
        return "NavDTO{" +
                "id=" + id +
                ", fundId=" + fundId +
                ", date=" + date +
                ", nav=" + nav +
                ", cnav=" + cnav +
                '}';
    }
}

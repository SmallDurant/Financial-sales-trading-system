package com.hundsun.fund.fund.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FundToManagerDTO {
    private Long id;
    private Long fundId;
    private Long managerId;
    private LocalDate appointmentDate;
    private BigDecimal performance;
    private BigDecimal appointmentAssetSize;
    private LocalDate endDate;

    // 构造函数
    public FundToManagerDTO() {
    }

    // 带所有参数的构造函数，用于方便地创建DTO对象
    public FundToManagerDTO(Long id, Long fundId, Long managerId, LocalDate appointmentDate,
                            BigDecimal performance, BigDecimal appointmentAssetSize, LocalDate endDate) {
        this.id = id;
        this.fundId = fundId;
        this.managerId = managerId;
        this.appointmentDate = appointmentDate;
        this.performance = performance;
        this.appointmentAssetSize = appointmentAssetSize;
        this.endDate = endDate;
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

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public BigDecimal getPerformance() {
        return performance;
    }

    public void setPerformance(BigDecimal performance) {
        this.performance = performance;
    }

    public BigDecimal getAppointmentAssetSize() {
        return appointmentAssetSize;
    }

    public void setAppointmentAssetSize(BigDecimal appointmentAssetSize) {
        this.appointmentAssetSize = appointmentAssetSize;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // toString方法，用于打印DTO的信息
    @Override
    public String toString() {
        return "FundToManagerDTO{" +
                "id=" + id +
                ", fundId=" + fundId +
                ", managerId=" + managerId +
                ", appointmentDate=" + appointmentDate +
                ", performance=" + performance +
                ", appointmentAssetSize=" + appointmentAssetSize +
                ", endDate=" + endDate +
                '}';
    }
}

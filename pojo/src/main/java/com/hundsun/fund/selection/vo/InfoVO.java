package com.hundsun.fund.selection.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author: Dding
 * @date: 2024/05/08
 **/
@Data
public class InfoVO implements Serializable {

    private Long account;

    private Boolean customerType;

    private Integer riskProfile;

    private LocalDateTime time;

    private LocalDate date;

    private String phoneNumber;

    private Integer requestType;

    private Integer accountType;

    private BigDecimal amount;

    private BigDecimal balance;

    private Integer status;

    private Integer industry;

    private Integer occupation;

    private String workUnit;

    private Integer educationalBackground;

    private Boolean isDishonest;

}

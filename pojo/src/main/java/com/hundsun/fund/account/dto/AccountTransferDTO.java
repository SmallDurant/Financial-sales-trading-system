package com.hundsun.fund.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/4/25 15:43
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransferDTO {
    private Long accountId;
    private BigDecimal amount;
    private String cardPassword;
}

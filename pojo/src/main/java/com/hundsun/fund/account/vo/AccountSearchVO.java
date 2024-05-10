package com.hundsun.fund.account.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/4/25 15:30
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountSearchVO {
    private Long accountId;
    private String cardNumber;
    private Integer belongBank;
    private BigDecimal balance;
}

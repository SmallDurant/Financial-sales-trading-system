package com.hundsun.fund.transaction.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: Dding
 * @date: 2024/04/25
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVO {

    private String name;

    private BigDecimal balance;

    private Byte status;
}

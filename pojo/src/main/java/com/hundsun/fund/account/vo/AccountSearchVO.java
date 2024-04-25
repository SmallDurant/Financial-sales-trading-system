package com.hundsun.fund.account.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date 2024/4/25 15:30
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountSearchVO {
    private String bankcardNumber;
    private Integer belongBank;
}

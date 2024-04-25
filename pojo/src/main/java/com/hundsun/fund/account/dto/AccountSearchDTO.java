package com.hundsun.fund.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date 2024/4/25 15:27
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountSearchDTO {
    private String account;
    private String idNumber;
    private String phoneNumber;
}

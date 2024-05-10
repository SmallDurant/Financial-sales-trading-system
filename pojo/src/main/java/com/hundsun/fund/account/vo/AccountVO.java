package com.hundsun.fund.account.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author
 * @Date 2024/5/9 下午2:07
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountVO {
    Long userId;
    String name;
    Integer accountStatus;
    Integer riskProfile;
    List<AccountSearchVO> accounts;
}

package com.hundsun.fund.account.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/4/25 16:02
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountSaveDTO {
    private String bankcardNumber;
    private String cardPassword;
    private Integer belongBank;
}

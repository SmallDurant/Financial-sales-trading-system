package com.hundsun.fund.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author
 * @Date 2024/4/25 15:23
 * @Description
 */
@TableName("taccount")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @TableId(type = IdType.AUTO)
    private Long accountId;
    private Long userId;
    private String cardNumber;
    private String cardPassword;
    private Integer type;
    private Integer status;
    private BigDecimal balance;
    private Integer belongBank;
}

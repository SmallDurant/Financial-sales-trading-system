package com.hundsun.fund.liquidation.entity;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class NetValueUpdate {
    Long fundId;

    BigDecimal netValue;


}

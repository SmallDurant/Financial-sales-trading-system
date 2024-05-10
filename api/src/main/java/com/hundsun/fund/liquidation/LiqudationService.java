package com.hundsun.fund.liquidation;

import com.hundsun.fund.liquidation.entity.NetValueUpdate;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

import java.math.BigDecimal;
import java.util.List;

@CloudService
public interface LiqudationService {

    //更新净值
    @CloudFunction("updateNetValue")
    Boolean updateNetValue(List<NetValueUpdate> netValueUpdates);

    //申购清算，更新持仓
    @CloudFunction("settleSubscription")
    Boolean settleSubscription();

    //赎回清算，更新用户账户表
    @CloudFunction("settleRedemption")
    Boolean settleRedemption();

}

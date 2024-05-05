package com.hundsun.fund.transaction;

import com.hundsun.fund.transaction.dto.BuyDTO;
import com.hundsun.fund.transaction.dto.SellDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

import java.math.BigDecimal;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@CloudService
public interface TransactionService {

    @CloudFunction("getUserNameByUserId")
    String getUserNameByUserId(Long userId);

    @CloudFunction("getUserBalanceByUserId")
    BigDecimal getUserBalanceByUserId(Long userId);

    @CloudFunction("getUserStatusByUserId")
    Integer getUserStatusByUserId(Long userId);


    @CloudFunction("getFundNameByFundCode")
    String getFundNameByFundCode(String fundCode);

    @CloudFunction("getFundCodeByFundName")
    String getFundCodeByFundName(String fundName);

    @CloudFunction("buyFund")
    void buyFund(BuyDTO buyDTO);

    @CloudFunction("sellFund")
    void sellFund(SellDTO sellDTO);

    @CloudFunction("cancelOrder")
    void cancelOrder(Long requestId);


    // TODO: 撤单相关逻辑
    @CloudFunction("addCancelRecord")
    void addCancelRecord(Long requestId);


}

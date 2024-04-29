package com.hundsun.fund.transaction;

import com.hundsun.fund.transaction.dto.BuyDTO;
import com.hundsun.fund.transaction.dto.CancelDTO;
import com.hundsun.fund.transaction.dto.SellDTO;
import com.hundsun.fund.transaction.vo.UserInfoVO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@CloudComponent
public interface TransactionService {

    @CloudFunction("getUserInfoByUserId")
    UserInfoVO getUserInfoByUserId(Long userId);

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
    void addCancelRecord(CancelDTO cancelDTO);


}

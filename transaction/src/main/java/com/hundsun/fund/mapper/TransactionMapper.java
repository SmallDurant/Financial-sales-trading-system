package com.hundsun.fund.mapper;

import com.hundsun.fund.transaction.dto.BuyDTO;
import com.hundsun.fund.transaction.dto.CancelDTO;
import com.hundsun.fund.transaction.dto.SellDTO;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface TransactionMapper {
    // TODO: SQL编写

    @Select("select fund_name from tFund where fund_code = #{fundCode}")
    String getFundNameByFundCode(String fundCode);

    @Select("select fund_code from tFund where fund_name = #{fundName}")
    String getFundCodeByFundName(String fundName);

    @Update("")
    void updateBalance(Long accountId, BigDecimal balance);

    @Update("")
    void updateShare(Long accountId, BigDecimal share);

    @Insert("")
    void addBuyTransactionRecord(BuyDTO buyDTO);

    @Insert("")
    void addSellTransactionRecord(SellDTO sellDTO);


    @Delete("")
    void deleteTransactionRecord(Long requestId);

    @Insert("")
    void addCancelRecord(CancelDTO cancelDTO);

}

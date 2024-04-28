package com.hundsun.fund.mapper;

import com.hundsun.fund.transaction.dto.BuyDTO;
import com.hundsun.fund.transaction.dto.SellDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface TransactionMapper {

    @Select("select fund_name from tFund where fund_code = #{fundCode}")
    String getFundNameByFundCode(String fundCode);

    @Select("select fund_code from tFund where fund_name = #{fundName}")
    String getFundCodeByFundName(String fundName);

    void updateBalance(BigDecimal balance);

    void updateShare(BigDecimal share);

    void addBuyTransactionRecord(BuyDTO buyDTO);

    void addSellTransactionRecord(SellDTO sellDTO);
}

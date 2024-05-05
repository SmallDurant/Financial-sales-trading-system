package com.hundsun.fund.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface TransactionMapper {
    // TODO: SQL编写

    @Select("select name from tuser where user_id = #{userId}")
    String getUserNameByUserId(Long userId);

    @Select("select balance from taccount where user_id = #{userId}")
    BigDecimal getUserBalanceByUserId(Long userId);

    @Select("select status from taccount where user_id = #{userId}")
    Integer getUserStatusByUserId(Long userId);

    @Select("select fund_name from tfund where fund_code = #{fundCode}")
    String getFundNameByFundCode(String fundCode);

    @Select("select fund_code from tfund where fund_name = #{fundName}")
    String getFundCodeByFundName(String fundName);

    @Select("select fund_risk from tfund where fund_code = #{fundCode}")
    Integer getFundRiskByFundCode(String fundCode);

    @Select("select risk_profile from tuser where account = #{account}")
    Integer getUserRiskByAccount(Long account);

    @Select("select balance from taccount where account_id = #{account}")
    BigDecimal getUserBalanceByAccount(Long account);

    @Select("select user_id from tuser where account = #{account}")
    Long getUserIdByAccount(Long account);

    @Update("update taccount set balance = balance - #{amount} where account_id = #{account}")
    void updateBalance(Long account, BigDecimal amount);

    @Insert("insert into trequest(user_id, account_id, type, fund_id, fund_name, amount, time, state) " +
            "values (#{userId}, #{accountId}, #{type}, #{fundCode}, #{fundName}, #{amount}, #{time}, #{state})")
    void addBuyTransactionRecord(Long userId, Long accountId, Integer type, String fundCode, String fundName, BigDecimal amount, LocalDateTime time, Integer state);

    @Insert("insert into trequest(user_id, account_id, type, fund_id, fund_name, amount, time, state) " +
            "values (#{userId}, #{accountId}, #{type}, #{fundCode}, #{fundName}, #{amount}, #{time}, #{state})")
    void addSellTransactionRecord(Long userId, Long accountId, Integer type, String fundCode, String fundName, BigDecimal amount, LocalDateTime time, Integer state);


    @Update("update trequest set state = 3 where request_id = #{requestId}")
    void deleteTransactionRecord(Long requestId);

    @Select("select user_id from trequest where request_id = #{requestId}")
    Long getUserIdByRequestId(Long requestId);

    @Insert("insert into tcancellation(user_id, request_id, time) values (#{userId}, #{requestId}, #{time})")
    void addCancelRecord(Long userId, Long requestId, LocalDateTime time);

}

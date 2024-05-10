package com.hundsun.fund.mapper;

import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface TransactionMapper {

    @Select("select purchase_rate from tfund where fund_code = #{fundCode}")
    BigDecimal getPurchaseRateByFundCode(@Param("fundCode") String fundCode);

    @Select("select nav from tfund where fund_code = #{fundCode}")
    BigDecimal getNavByFundCode(@Param("fundCode") String fundCode);

    @Select("select fund_id from tfund where fund_code = #{fundCode}")
    Long getFundIdByFundCode(@Param("fundCode") String fundCode);

    @Update("update tportion set frozen_portion = frozen_portion + #{portion} where user_id = #{userId} and account_id = #{accountId} and fund_id = #{fundId}")
    void updatePositionFrozenPortion(@Param("userId") Long userId, @Param("accountId") Long accountId, @Param("fundId") Long fundId, @Param("portion") BigDecimal portion);

    @Select("select name from tuser where user_id = #{userId}")
    String getUserNameByUserId(@Param("userId") Long userId);

    @Select("select balance from taccount where user_id = #{userId}")
    BigDecimal getUserBalanceByUserId(@Param("userId") Long userId);

    @Select("select status from taccount where user_id = #{userId}")
    Integer getUserStatusByUserId(@Param("userId") Long userId);

    @Select("select fund_name from tfund where fund_code = #{fundCode}")
    String getFundNameByFundCode(@Param("fundCode") String fundCode);

    @Select("select fund_code from tfund where fund_name = #{fundName}")
    String getFundCodeByFundName(@Param("fundName") String fundName);

    @Select("select fund_risk from tfund where fund_code = #{fundCode}")
    Integer getFundRiskByFundCode(@Param("fundCode") String fundCode);

    @Select("select risk_profile from tuser where account = #{account}")
    Integer getUserRiskByAccount(@Param("account") Long account);

    @Select("select balance from taccount where account_id = #{account}")
    BigDecimal getUserBalanceByAccount(@Param("account") Long account);

    @Select("select user_id from tuser where account = #{account}")
    Long getUserIdByAccount(@Param("account") Long account);

    @Update("update taccount set balance = balance - #{amount} where account_id = #{account}")
    void updateBalance(@Param("account") Long account,@Param("amount") BigDecimal amount);

    @Insert("insert into trequest(user_id, account_id, type, fund_id, fund_name, amount, time, state) " +
            "values (#{userId}, #{accountId}, #{type}, #{fundCode}, #{fundName}, #{amount}, #{time}, #{state})")
    void addBuyTransactionRecord(@Param("userId") Long userId,@Param("accountId") Long accountId,@Param("type") Integer type,@Param("fundCode") String fundCode,@Param("fundName") String fundName,@Param("amount") BigDecimal amount,@Param("time") LocalDateTime time,@Param("state") Integer state);

    @Insert("insert into trequest(user_id, account_id, type, fund_id, fund_name, amount, time, state) " +
            "values (#{userId}, #{accountId}, #{type}, #{fundCode}, #{fundName}, #{amount}, #{time}, #{state})")
    void addSellTransactionRecord(@Param("userId") Long userId,@Param("accountId") Long accountId,@Param("type") Integer type,@Param("fundCode") String fundCode,@Param("fundName") String fundName,@Param("amount") BigDecimal amount,@Param("time") LocalDateTime time,@Param("state") Integer state);


    @Update("update trequest set state = 3 where request_id = #{requestId}")
    void deleteTransactionRecord(@Param("requestId") Long requestId);

    @Select("select user_id from trequest where request_id = #{requestId}")
    Long getUserIdByRequestId(@Param("requestId") Long requestId);

    @Insert("insert into tcancellation(cancellation_id, user_id, request_id, time) values (#{cancellationId} ,#{userId}, #{requestId}, #{time})")
    void addCancelRecord(@Param("cancellationId") Long cancellationId,@Param("userId") Long userId,@Param("requestId") Long requestId,@Param("time") LocalDateTime time);

}

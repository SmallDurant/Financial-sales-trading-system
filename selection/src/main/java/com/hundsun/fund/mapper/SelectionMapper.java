package com.hundsun.fund.mapper;

import com.hundsun.fund.selection.vo.BuyRecordVO;
import com.hundsun.fund.selection.vo.PortionVO;
import com.hundsun.fund.selection.vo.RecordVO;
import com.hundsun.fund.selection.vo.SellRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface SelectionMapper {

    /************************************************************************/

    @Select("select customer_type from tuser where user_id = #{userId}")
    Boolean getCustomerTypeByUserId(@Param("userId") Long userId);

    @Select("select risk_profile from tuser where user_id = #{userId}")
    Integer getRiskProfileByUserId(@Param("userId") Long userId);

    @Select("select time(time) from trequest where request_id = #{requestId}")
    LocalDateTime getTimeByRequestId(@Param("requestId") Long requestId);

    @Select("select date(time) from trequest where request_id = #{requestId}")
    LocalDate getDateByRequestId(@Param("requestId") Long requestId);

    @Select("select phone_number from tuser where user_id = #{userId}")
    String getPhoneNumberByUserId(@Param("userId") Long userId);

    @Select("select type from trequest where request_id = #{requestId}")
    Integer getRequestTypeByRequestId(@Param("requestId") Long requestId);

    @Select("select type from taccount where account_id = #{accountId}")
    Integer getAccountTypeByAccountId(@Param("accountId") Long accountId);

    @Select("select amount from trequest where request_id = #{requestId}")
    BigDecimal getAmountByRequestId(@Param("requestId") Long requestId);

    @Select("select balance from taccount where account_id = #{accountId}")
    BigDecimal getBalanceByAccountId(@Param("accountId") Long accountId);

    @Select("select status from taccount where account_id = #{accountId}")
    Integer getStatusByAccountId(@Param("accountId") Long accountId);

    @Select("select industry from tuser where user_id = #{userId}")
    Integer getIndustryByUserId(@Param("userId") Long userId);

    @Select("select occupation from tuser where user_id = #{userId}")
    Integer getOccupationByUserId(@Param("userId") Long userId);

    @Select("select work_unit from tuser where user_id = #{userId}")
    String getWorkUnitByUserId(@Param("userId") Long userId);

    @Select("select educational_background from tuser where user_id = #{userId}")
    Integer getEducationalBackgroundByUserId(@Param("userId") Long userId);

    @Select("select is_dishonest from tuser where user_id = #{userId}")
    Boolean getIsDishonestByUserId(@Param("userId") Long userId);

    /************************************************************************/


    @Select("select user_id from trequest where request_id = #{requestId}")
    Long getUserIdByRequestId(@Param("requestId") Long requestId);

    @Select("select account_id from trequest where request_id = #{requestId}")
    Long getAccountIdByRequestId(@Param("requestId") Long requestId);

    @Select("select fund_id from tfund where fund_code = #{fundCode}")
    Long getFundIdByFundCode(@Param("fundCode") String fundCode);

    List<RecordVO> getTransactionRecord(@Param("accountId") Long accountId,@Param("fundId") Long fundId,@Param("startDateTime") LocalDateTime startDateTime,@Param("endDateTime") LocalDateTime endDateTime);

    @Update("update trequest set state = #{state} where request_id = #{requestId}")
    void updateStateByRequestId(@Param("requestId") Long requestId,@Param("state") Integer state);

    List<PortionVO> getUserPortion(@Param("userId") Long userId);

    @Update("update taccount set balance = balance - #{amount} where account_id = #{account}")
    void updateBalance(@Param("account") Long account,@Param("amount") BigDecimal amount);

    @Select("select fund_id, user_id, account_id, amount from trequest " +
            "where type = 0 and " +
            "date(time) " +
            "between cast(concat(date_sub(#{date}, interval 4 day), ' ', '15:00:00') as datetime) " +
            "and cast(concat(date_sub(#{date}, interval 3 day), ' ', '15:00:00') as datetime) ")
    List<BuyRecordVO> getBuyRecord_1(@Param("date") LocalDate date);

    @Select("select fund_id, user_id, account_id, amount from trequest " +
            "where type = 0 " +
            "and date(time) " +
            "between cast(concat(date_sub(#{date}, interval 4 day), ' ', '15:00:00') as datetime) " +
            "and cast(concat(date_sub(#{date}, interval 1 day), ' ', '15:00:00') as datetime) ")
    List<BuyRecordVO> getBuyRecord_2(@Param("date") LocalDate date);

    @Select("select fund_id, user_id, account_id, amount from trequest " +
            "where type = 0 " +
            "and date(time) " +
            "between cast(concat(date_sub(#{date}, interval 1 day), ' ', '15:00:00') as datetime) " +
            "and cast(concat(#{date}, ' ', '15:00:00') as datetime) ")
    List<BuyRecordVO> getBuyRecord(@Param("date") LocalDate date);


    @Select("select fund_id, user_id, account_id, amount from trequest " +
            "where type = 1 and " +
            "date(time) " +
            "between cast(concat(date_sub(#{date}, interval 4 day), ' ', '15:00:00') as datetime) " +
            "and cast(concat(date_sub(#{date}, interval 3 day), ' ', '15:00:00') as datetime) ")
    List<SellRecordVO> getSellRecord_1(@Param("date") LocalDate date);

    @Select("select fund_id, user_id, account_id, amount from trequest " +
            "where type = 1 " +
            "and date(time) " +
            "between cast(concat(date_sub(#{date}, interval 4 day), ' ', '15:00:00') as datetime) " +
            "and cast(concat(date_sub(#{date}, interval 1 day), ' ', '15:00:00') as datetime) ")
    List<SellRecordVO> getSellRecord_2(@Param("date") LocalDate date);

    @Select("select fund_id, user_id, account_id, amount from trequest " +
            "where type = 1 " +
            "and date(time) " +
            "between cast(concat(date_sub(#{date}, interval 1 day), ' ', '15:00:00') as datetime) " +
            "and cast(concat(#{date}, ' ', '15:00:00') as datetime) ")
    List<SellRecordVO> getSellRecord(@Param("date") LocalDate date);

}

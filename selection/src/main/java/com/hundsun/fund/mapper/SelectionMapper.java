package com.hundsun.fund.mapper;

import com.hundsun.fund.selection.vo.BuyRecordVO;
import com.hundsun.fund.selection.vo.PortionVO;
import com.hundsun.fund.selection.vo.RecordVO;
import com.hundsun.fund.selection.vo.SellRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface SelectionMapper {

    @Select("select fund_id from tfund where fund_code = #{fundCode}")
    Long getFundIdByFundCode(@Param("fundCode") String fundCode);

    List<RecordVO> getTransactionRecord(@Param("accountId") Long accountId,@Param("fundId") Long fundId,@Param("startDateTime") LocalDateTime startDateTime,@Param("endDateTime") LocalDateTime endDateTime);

    @Update("update trequest set state = #{state} where request_id = #{requestId}")
    void updateStateByRequestId(@Param("requestId") Long requestId,@Param("state") Integer state)

    List<PortionVO> getUserPortion(@Param("userId") Long userId);

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

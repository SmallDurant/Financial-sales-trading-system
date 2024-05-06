package com.hundsun.fund.mapper;

import com.hundsun.fund.selection.vo.HistoryDataVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface HomepageDataMapper {

    @Select("select count(*) from trequest where state = 0 and date(time) = #{now}")
    Integer getConfirmedNum(@Param("now") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate now);

    @Select("select count(*) from trequest where state = 2 and date(time) = #{now}")
    Integer getUnconfirmedNum(@Param("now") LocalDate now);

    @Select("select count(*) from trequest where type = 0 and date(time) = #{now}")
    Integer getBuyNum(@Param("now") LocalDate now);

    @Select("select count(*) from trequest where type = 1 and date(time) = #{now}")
    Integer getSellNum(@Param("now") LocalDate now);

    @Select("select count(*) from trequest where state = 3 and date(time) = #{now}")
    Integer getCancelNum(@Param("now") LocalDate now);

    @Select("select count(*) from tfund where is_delete = 0")
    Integer getFundNum();

    @Select("select date(time) as date, count(*) as num from trequest where type = 0 group by date(time) order by date(time)")
    List<HistoryDataVO> getBuyHistoryNum();

    @Select("select date(time) as date, count(*) as num from trequest where type = 1 group by date(time) order by date(time)")
    List<HistoryDataVO> getSellHistoryNum();

    @Select("select date(time) as date, count(*) as num from trequest where state = 3 group by date(time) order by date(time)")
    List<HistoryDataVO> getCancelHistoryNum();
}

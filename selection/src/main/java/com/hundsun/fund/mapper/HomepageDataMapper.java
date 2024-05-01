package com.hundsun.fund.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface HomepageDataMapper {

    @Select("select count(*) from trequest where state = 0 and time = #{now}")
    Integer getConfirmedNum(@Param("now") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate now);

    @Select("select count(*) from trequest where state = 2 and time = #{now}")
    Integer getUnconfirmedNum(@Param("now") LocalDate now);

    @Select("select count(*) from trequest where type = 0 and time = #{now}")
    Integer getBuyNum(@Param("now") LocalDate now);

    @Select("select count(*) from trequest where type = 1 and time = #{now}")
    Integer getSellNum(@Param("now") LocalDate now);

    @Select("select count(*) from trequest where status = 3 and time = #{now}")
    Integer getCancelNum(@Param("now") LocalDate now);

    @Select("select count(*) from tfund where is_delete = 0")
    Integer getFundNum();
}

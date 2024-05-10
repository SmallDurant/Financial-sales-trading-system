package com.hundsun.fund.mapper;

import com.hundsun.fund.log.vo.LogRecordVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/28
 **/
@Mapper
public interface LogMapper {

    //@Select("select * from tlog limit #{start}, #{size}")
    List<LogRecordVO> getLogRecord(@Param("start") Long start, @Param("size") Long size);

    //@Insert("insert into tlog (employ_id, type, detail, time) values (#{EmployeeId}, #{type}, #{detail}, #{time})")
    int addLogRecord(@Param("employeeId") Long employeeId,
                      @Param("type") Integer type,
                      @Param("detail") String detail,
                      @Param("time") LocalDateTime time);




}

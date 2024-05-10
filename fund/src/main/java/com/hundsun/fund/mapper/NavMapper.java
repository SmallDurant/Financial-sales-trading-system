package com.hundsun.fund.mapper;

import com.hundsun.fund.fund.dto.NavDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface NavMapper {
    // 创建新的tnav记录
    int createNav(@Param("navDTO") NavDTO navDTO);

    // 更新已有的tnav记录
    int updateNav(@Param("fundId") Long fundId, @Param("date") LocalDate date, @Param("navDTO") NavDTO navDTO);

    // 查询所有的nav记录
    List<NavDTO> findAllNavs();

    // 根据ID查询单个tnav记录
    List<NavDTO> findNavById(@Param("id") Long fundId);

    // 查找某天的nav记录
    List<NavDTO> findNavByDate(@Param("date") LocalDate date);

    // 查找基金ID具体某天的nav记录
    NavDTO findNavByDateAndID(@Param("id") Long fundId, @Param("date") LocalDate date);
}

package com.hundsun.fund.mapper;

import com.hundsun.fund.fund.dto.FundToManagerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FundToManagerMapper {
    List<FundToManagerDTO> findByFundId(@Param("fundId") Long fundId);

    List<FundToManagerDTO> findByManagerId(@Param("managerId") Long managerId);

    int updateFundToManager(@Param("id") Long Id,@Param("fundToManager")FundToManagerDTO fundToManager);

    int addFundToManager(@Param("fundToManager")FundToManagerDTO fundToManager);
}

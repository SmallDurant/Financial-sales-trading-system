package com.hundsun.fund.mapper;


import com.hundsun.fund.fund.dto.FundportionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface PortionMapper {

    List<FundportionDTO> findPortion(@Param("userId") Long userId);

    int createPortion(
            @Param("userId") Long userId,
            @Param("accountId") Long accountId,
            @Param("fundId") Long fundId,
            @Param("portion") BigDecimal portion
    );

    int updatePositionPortion(
            @Param("userId") Long userId,
            @Param("accountId") Long accountId,
            @Param("fundId") Long fundId,
            @Param("additionalPortion") BigDecimal additionalPortion
    );

    int updatePositionFrozenPortion(
            @Param("userId") Long userId,
            @Param("accountId") Long accountId,
            @Param("fundId") Long fundId,
            @Param("additionalFrozenPortion") BigDecimal additionalFrozenPortion
    );

    int cutPositionFrozenPortion(
            @Param("userId") Long userId,
            @Param("accountId") Long accountId,
            @Param("fundId") Long fundId,
            @Param("cutFrozenPortion") BigDecimal cutFrozenPortion
    );

    boolean checkRecordExists(
            @Param("userId") Long userId,
            @Param("accountId") Long accountId,
            @Param("fundId") Long fundId
    );

    boolean isFrozenPortionLessThanPortion(
            @Param("userId") Long userId,
            @Param("accountId") Long accountId,
            @Param("fundId") Long fundId,
            @Param("additionalFrozenPortion") BigDecimal additionalFrozenPortion
    );

}

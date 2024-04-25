package com.hundsun.fund.fund;

import com.hundsun.fund.fund.dto.FundportionDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;
import org.springframework.web.bind.annotation.PathVariable;


import java.math.BigDecimal;
import java.util.List;

@CloudService
public interface PortionService {
    //获取指定用户的持仓情况
    @CloudFunction("findPortion")
    List<FundportionDTO> findPortion(@PathVariable Long userId);

    //根据用户ID和账户ID和基金ID创建持仓
    @CloudFunction("createPortion")
    int createPortion(
            @PathVariable Long userId,
            @PathVariable Long accountId,
            @PathVariable Long fundId,
            @PathVariable BigDecimal portion
    );


    //根据用户ID和账户ID和基金ID更新持仓（增加份额）
    @CloudFunction("updatePositionPortion")
    Boolean updatePositionPortion(
            @PathVariable Long userId,
            @PathVariable Long accountId,
            @PathVariable Long fundId,
            @PathVariable BigDecimal additionalPortion
    );

    //根据用户ID和账户ID和基金ID更新持仓（增加冻结份额）
    @CloudFunction("updatePositionFrozenPortion")
    int updatePositionFrozenPortion(
            @PathVariable Long userId,
            @PathVariable Long accountId,
            @PathVariable Long fundId,
            @PathVariable BigDecimal additionalFrozenPortion
    );

    //赎回成功
    @CloudFunction("cutPositionFrozenPortion")
    Boolean cutPositionFrozenPortion(
            @PathVariable Long userId,
            @PathVariable Long accountId,
            @PathVariable Long fundId,
            @PathVariable BigDecimal cutFrozenPortion
    );



}

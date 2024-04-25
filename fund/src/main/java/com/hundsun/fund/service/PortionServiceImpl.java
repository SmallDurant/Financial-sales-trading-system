package com.hundsun.fund.service;

import com.hundsun.fund.fund.PortionService;
import com.hundsun.fund.fund.dto.FundDTO;
import com.hundsun.fund.fund.dto.FundportionDTO;
import com.hundsun.fund.mapper.PortionMapper;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
@CloudComponent
public class PortionServiceImpl implements PortionService {
    @Autowired
    private PortionMapper portionMapper;

    @Override
    public List<FundportionDTO> findPortion(Long userId) {
        return portionMapper.findPortion(userId);
    }

    @Override
    public int createPortion(Long userId, Long accountId, Long fundId, BigDecimal portion) {

        if(!portionMapper.checkRecordExists(userId,accountId,fundId)){
            return portionMapper.createPortion(userId, accountId, fundId, portion);
        }
        return -1;
    }

    @Override
    public Boolean updatePositionPortion(Long userId, Long accountId, Long fundId, BigDecimal additionalPortion) {

        return portionMapper.updatePositionPortion(userId, accountId, fundId, additionalPortion) > 0;
    }

    @Override
    public int updatePositionFrozenPortion(Long userId, Long accountId, Long fundId, BigDecimal additionalFrozenPortion) {

        if(portionMapper.isFrozenPortionLessThanPortion(userId, accountId, fundId, additionalFrozenPortion)){
            return portionMapper.updatePositionFrozenPortion(userId, accountId, fundId, additionalFrozenPortion);
        }
        return -1;
    }

    @Override
    public Boolean cutPositionFrozenPortion(Long userId, Long accountId, Long fundId, BigDecimal cutFrozenPortion) {

        return portionMapper.cutPositionFrozenPortion(userId, accountId, fundId, cutFrozenPortion) > 0;
    }
}

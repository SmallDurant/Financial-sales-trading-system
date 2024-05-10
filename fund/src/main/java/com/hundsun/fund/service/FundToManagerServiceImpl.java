package com.hundsun.fund.service;

import com.hundsun.fund.fund.FundToManagerService;
import com.hundsun.fund.fund.dto.FundToManagerDTO;
import com.hundsun.fund.mapper.FundMapper;
import com.hundsun.fund.mapper.FundToManagerMapper;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@CloudComponent
public class FundToManagerServiceImpl implements FundToManagerService {

    @Autowired
    private FundToManagerMapper fundToManagerMapper;

    @Override
    public List<FundToManagerDTO> findByFundId(Long fundId) {

        return fundToManagerMapper.findByFundId(fundId);
    }

    @Override
    public List<FundToManagerDTO> findByManagerId(Long managerId) {

        return fundToManagerMapper.findByManagerId(managerId);
    }

    @Override
    public Boolean updateFundToManager(Long id, FundToManagerDTO fundToManager) {

        return fundToManagerMapper.updateFundToManager(id, fundToManager) > 0;
    }

    @Override
    public Boolean addFundToManager(FundToManagerDTO fundToManager) {

        return fundToManagerMapper.addFundToManager(fundToManager) > 0;
    }
}

package com.hundsun.fund.service;



import com.hundsun.fund.fund.FundService;
import com.hundsun.fund.fund.dto.FundDTO;
import com.hundsun.fund.mapper.FundMapper;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;


@CloudComponent
public class FundServiceImpl implements FundService {
    @Autowired
    private FundMapper fundMapper;
    @Override
    public List<FundDTO> findAllFunds() {

        return fundMapper.findAllFunds();
    }

    @Override
    public List<FundDTO> findAll() {

        return fundMapper.findAll();
    }

    @Override
    public FundDTO findFundById(Long fundId) {

        return fundMapper.findFundById(fundId);
    }

    @Override
    public Boolean createFund(FundDTO fund) {

        int result = fundMapper.createFund(fund);
        return result > 0;
    }

    @Override
    public Boolean updateFund(Long fundId, FundDTO fundDTO) {

        int result = fundMapper.updateFund(fundId, fundDTO);
        return result > 0;
    }

    @Override
    public Boolean deleteFund(Long fundId) {

        int result = fundMapper.deleteFund(fundId);
        return result > 0;
    }

    @Override
    public int findFundcount() {

        return fundMapper.findAllFunds().size();

    }
}
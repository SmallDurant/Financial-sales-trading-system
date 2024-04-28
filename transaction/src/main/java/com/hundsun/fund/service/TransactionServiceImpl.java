package com.hundsun.fund.service;

import com.hundsun.fund.mapper.TransactionMapper;
import com.hundsun.fund.transaction.TransactionService;
import com.hundsun.fund.transaction.dto.BuyDTO;
import com.hundsun.fund.transaction.dto.SellDTO;
import com.hundsun.fund.transaction.vo.UserInfoVO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@CloudComponent
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Resource
    private TransactionMapper transactionMapper;

    @Override
    public UserInfoVO getUserInfoByUserId(Long userId) {
        // TODO:待确定
        return null;
    }

    @Override
    public String getFundNameByFundCode(String fundCode) {
        return transactionMapper.getFundNameByFundCode(fundCode);
    }

    @Override
    public String getFundCodeByFundName(String fundName) {
        return transactionMapper.getFundCodeByFundName(fundName);
    }

    @Override
    public void buyFund(BuyDTO buyDTO) {
        log.info("用户金额");
        transactionMapper.updateBalance(buyDTO.getaccountId(), buyDTO.getBalance());
        transactionMapper.updateShare(buyDTO.getaccountId(), buyDTO.getShare());
        transactionMapper.addBuyTransactionRecord(buyDTO);

    }

    @Override
    public void sellFund(SellDTO sellDTO) {
        transactionMapper.updateShare(sellDTO.getaccountId(), sellDTO.getShare());
        transactionMapper.updateBalance(sellDTO.getaccountId(), sellDTO.getBalance());
        transactionMapper.addSellTransactionRecord(sellDTO);
    }


}

package com.hundsun.fund.service;

import com.hundsun.fund.mapper.TransactionMapper;
import com.hundsun.fund.transaction.TransactionService;
import com.hundsun.fund.transaction.dto.BuyDTO;
import com.hundsun.fund.transaction.dto.CancelDTO;
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
        transactionMapper.updateBalance(buyDTO.getAccountId(), buyDTO.getBalance());
        transactionMapper.updateShare(buyDTO.getAccountId(), buyDTO.getShare());
        transactionMapper.addBuyTransactionRecord(buyDTO);

    }

    @Override
    public void sellFund(SellDTO sellDTO) {
        transactionMapper.updateShare(sellDTO.getAccountId(), sellDTO.getShare());
        transactionMapper.updateBalance(sellDTO.getAccountId(), sellDTO.getBalance());
        transactionMapper.addSellTransactionRecord(sellDTO);
    }

    @Override
    public void cancelOrder(Long requestId) {
        transactionMapper.deleteTransactionRecord(requestId);
    }

    @Override
    public void addCancelRecord(CancelDTO cancelDTO) {
        transactionMapper.addCancelRecord(cancelDTO);
    }


}

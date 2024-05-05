package com.hundsun.fund.service;

import com.hundsun.fund.mapper.TransactionMapper;
import com.hundsun.fund.transaction.TransactionService;
import com.hundsun.fund.transaction.dto.BuyDTO;
import com.hundsun.fund.transaction.dto.SellDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    public String getUserNameByUserId(Long userId) {
        return transactionMapper.getUserNameByUserId(userId);
    }

    @Override
    public BigDecimal getUserBalanceByUserId(Long userId) {
        return transactionMapper.getUserBalanceByUserId(userId);
    }

    @Override
    public Integer getUserStatusByUserId(Long userId) {
        return transactionMapper.getUserStatusByUserId(userId);
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
        Integer fundRisk = transactionMapper.getFundRiskByFundCode(buyDTO.getFundCode());
        Integer userRisk = transactionMapper.getUserRiskByAccount(buyDTO.getAccount());
        BigDecimal balance = transactionMapper.getUserBalanceByAccount(buyDTO.getAccount());
        Long userId = transactionMapper.getUserIdByAccount(buyDTO.getAccount());

        if(fundRisk < userRisk){
            if(buyDTO.getAmount().compareTo(balance) < 0){
                transactionMapper.updateBalance(buyDTO.getAccount(), buyDTO.getAmount());
                // TODO: 调用更新持仓接口 updatePositionPortion updatePositionFrozenPortion
                transactionMapper.addBuyTransactionRecord(userId, buyDTO.getAccount(), 0, buyDTO.getFundCode(), buyDTO.getFundName(), buyDTO.getAmount(), LocalDateTime.now(), 2);
            }else {
                throw new RuntimeException("余额不足");
            }
        }else {
            throw new RuntimeException("风险等级不够");
        }



    }

    @Override
    public void sellFund(SellDTO sellDTO) {
        Long userId = transactionMapper.getUserIdByAccount(sellDTO.getAccount());

        // TODO: 调用更新持仓接口 updatePositionPortion
        transactionMapper.addSellTransactionRecord(userId, sellDTO.getAccount(), 1, sellDTO.getFundCode(), sellDTO.getFundName(), sellDTO.getAmount(), LocalDateTime.now(), 2);
    }

    @Override
    public void cancelOrder(Long requestId) {
        transactionMapper.deleteTransactionRecord(requestId);
    }

    @Override
    public void addCancelRecord(Long requestId) {
        Long userId = transactionMapper.getUserIdByRequestId(requestId);
        transactionMapper.addCancelRecord(userId ,requestId, LocalDateTime.now());
    }


}

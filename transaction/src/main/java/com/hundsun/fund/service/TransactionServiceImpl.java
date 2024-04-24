package com.hundsun.fund.service;

import com.hundsun.fund.mapper.TransactionMapper;
import com.hundsun.fund.user.TransactionService;
import com.hundsun.fund.transaction.dto.TransactionRecordDTO;
import com.hundsun.fund.transaction.vo.TransactionRecordVO;
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
    public TransactionRecordVO getTransactionRecord(TransactionRecordDTO transactionRecordDTO) {
        log.info("查询交易记录");
        return transactionMapper.getTransactionRecord(transactionRecordDTO);
    }
}

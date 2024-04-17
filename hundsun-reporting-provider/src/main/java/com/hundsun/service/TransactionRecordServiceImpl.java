package com.hundsun.service;

import com.hundsun.dto.TransactionRecordDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.mapper.TransactionRecordMapper;
import com.hundsun.reporting.TransactionRecordService;
import com.hundsun.vo.TransactionRecordVO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/17
 **/
@CloudComponent
@Slf4j
public class TransactionRecordServiceImpl implements TransactionRecordService {

    private TransactionRecordMapper transactionRecordMapper;

    /**
     * 查询交易记录
     * @param transactionRecordDTO
     * @return
     */
    @Override
    public List<TransactionRecordVO> getRecord(TransactionRecordDTO transactionRecordDTO) {
        log.info("查询条件: {}", transactionRecordDTO);
        return transactionRecordMapper.getRecord(transactionRecordDTO);
    }
}

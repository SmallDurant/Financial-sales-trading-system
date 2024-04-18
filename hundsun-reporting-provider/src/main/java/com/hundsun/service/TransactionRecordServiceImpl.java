package com.hundsun.service;

import com.hundsun.dto.TransactionRecordDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.mapper.TransactionRecordMapper;
import com.hundsun.reporting.TransactionRecordService;
import com.hundsun.vo.TransactionRecordVO;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/17
 **/
@CloudComponent
@Slf4j
public class TransactionRecordServiceImpl implements TransactionRecordService {

    @Resource
    private TransactionRecordMapper transactionRecordMapper;

    /**
     * 根据id查询交易记录
     * @param id
     * @return
     */
    @Override
    public TransactionRecordVO getRecordById(Long id) {
        log.info("查询id: {}", id);
        return transactionRecordMapper.getRecordById(id);
    }

    /**
     * 根据条件查询交易记录
     * @param transactionRecordDTO
     * @return
     */
    @Override
    public List<TransactionRecordVO> getRecord(TransactionRecordDTO transactionRecordDTO) {
        log.info("查询条件: {}", transactionRecordDTO);
        return transactionRecordMapper.getRecord(transactionRecordDTO);
    }
}

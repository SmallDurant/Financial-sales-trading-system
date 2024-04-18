package com.hundsun.reporting;

import com.hundsun.dto.TransactionRecordDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudService;
import com.hundsun.vo.TransactionRecordVO;

import java.util.List;

@CloudService
public interface TransactionRecordService {

    /**
     * 根据id查询交易记录
     * @param id
     * @return
     */
    public TransactionRecordVO getRecordById(Long id);

    /**
     * 查询交易记录
     * @param transactionRecordDTO
     * @return
     */
    // @CloudFunction("TransactionRecord")
    public List<TransactionRecordVO> getRecord(TransactionRecordDTO transactionRecordDTO);
}

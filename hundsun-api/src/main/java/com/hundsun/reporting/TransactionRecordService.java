package com.hundsun.reporting;

import com.hundsun.dto.TransactionRecordDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;
import com.hundsun.vo.TransactionRecordVO;

import java.util.List;

@CloudService
public interface TransactionRecordService {
    @CloudFunction("TransactionRecord")
    public List<TransactionRecordVO> getRecord(TransactionRecordDTO transactionRecordDTO);
}

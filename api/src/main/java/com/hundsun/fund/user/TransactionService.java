package com.hundsun.fund.user;

import com.hundsun.fund.transaction.dto.TransactionRecordDTO;
import com.hundsun.fund.transaction.vo.TransactionRecordVO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@CloudComponent
public interface TransactionService {

    @CloudFunction("getTransactionRecord")
    TransactionRecordVO getTransactionRecord(TransactionRecordDTO transactionRecordDTO);
}

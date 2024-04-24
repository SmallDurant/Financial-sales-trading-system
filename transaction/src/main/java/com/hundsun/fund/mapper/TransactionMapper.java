package com.hundsun.fund.mapper;

import com.hundsun.fund.transaction.dto.TransactionRecordDTO;
import com.hundsun.fund.transaction.vo.TransactionRecordVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface TransactionMapper {

    TransactionRecordVO getTransactionRecord(TransactionRecordDTO transactionRecordDTO);
}

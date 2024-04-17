package com.hundsun.mapper;

import com.hundsun.dto.TransactionRecordDTO;
import com.hundsun.vo.TransactionRecordVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/16
 **/
@Mapper
public interface TransactionRecordMapper {


    /**
     * 从数据库获取交易记录
     * @param transactionRecordDTO
     * @return
     */
    List<TransactionRecordVO> getRecord(TransactionRecordDTO transactionRecordDTO);
}

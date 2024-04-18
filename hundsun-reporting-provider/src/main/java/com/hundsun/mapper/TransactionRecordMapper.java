package com.hundsun.mapper;

import com.hundsun.dto.TransactionRecordDTO;
import com.hundsun.vo.TransactionRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/16
 **/
@Mapper
public interface TransactionRecordMapper {

    /**
     * 根据id从数据库获取交易记录
     * @param id
     * @return
     */
    @Select("select * from trequest where request_id = #{id}")
    TransactionRecordVO getRecordById(Long id);

    /**
     * 根据条件从数据库获取交易记录
     * @param transactionRecordDTO
     * @return
     */
    List<TransactionRecordVO> getRecord(TransactionRecordDTO transactionRecordDTO);
}

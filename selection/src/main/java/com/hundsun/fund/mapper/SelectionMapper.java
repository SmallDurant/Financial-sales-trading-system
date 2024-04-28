package com.hundsun.fund.mapper;

import com.hundsun.fund.selection.dto.RecordDTO;
import com.hundsun.fund.selection.vo.RecordVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface SelectionMapper {

    RecordVO getTransactionRecord(RecordDTO recordDTO);
}

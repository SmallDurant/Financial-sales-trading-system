package com.hundsun.fund.mapper;

import com.hundsun.fund.selection.dto.RecordDTO;
import com.hundsun.fund.selection.vo.PortionVO;
import com.hundsun.fund.selection.vo.RecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface SelectionMapper {

    RecordVO getTransactionRecord(RecordDTO recordDTO);

    List<PortionVO> getUserPortion(@Param("userId") Long userId);
}

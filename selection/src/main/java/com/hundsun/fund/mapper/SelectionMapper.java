package com.hundsun.fund.mapper;

import com.hundsun.fund.selection.dto.RecordDTO;
import com.hundsun.fund.selection.vo.BuyRecordVO;
import com.hundsun.fund.selection.vo.PortionVO;
import com.hundsun.fund.selection.vo.RecordVO;
import com.hundsun.fund.selection.vo.SellRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@Mapper
public interface SelectionMapper {

    RecordVO getTransactionRecord(RecordDTO recordDTO);

    List<PortionVO> getUserPortion(@Param("userId") Long userId);

    List<BuyRecordVO> getBuyRecord(@Param("date") LocalDate date);

    List<SellRecordVO> getSellRecord(@Param("date") LocalDate date);

}

package com.hundsun.fund.service;

import com.hundsun.fund.mapper.SelectionMapper;
import com.hundsun.fund.selection.SelectionService;
import com.hundsun.fund.selection.dto.RecordDTO;
import com.hundsun.fund.selection.vo.BuyRecordVO;
import com.hundsun.fund.selection.vo.PortionVO;
import com.hundsun.fund.selection.vo.RecordVO;
import com.hundsun.fund.selection.vo.SellRecordVO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@CloudComponent
@Slf4j
public class SelectionServiceImpl implements SelectionService {

    @Resource
    private SelectionMapper selectionMapper;

    @Override
    public RecordVO getTransactionRecord(RecordDTO recordDTO) {
        log.info("查询交易记录");
        return selectionMapper.getTransactionRecord(recordDTO);
    }

    @Override
    public List<PortionVO> getUserPortion(Long userId) {
        List<PortionVO> list = selectionMapper.getUserPortion(userId);
        return list;
    }

    @Override
    public List<BuyRecordVO> getBuyRecordByDate(LocalDate date) {
        // TODO: 判断周几
        return selectionMapper.getBuyRecord(date);
    }
    @Override
    public List<SellRecordVO> getSellRecordByDate(LocalDate date) {
        return selectionMapper.getSellRecord(date);
    }
}

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
    public List<RecordVO> getTransactionRecord(RecordDTO recordDTO) {
        Long fundId = selectionMapper.getFundIdByFundCode(recordDTO.getFundCode());
        log.info("查询交易记录");
        return selectionMapper.getTransactionRecord(recordDTO.getAccountId(), fundId, recordDTO.getStartDateTime(), recordDTO.getEndDateTime());
    }

    @Override
    public void updateStateByRequestId(Long requestId, Integer state) {
        selectionMapper.updateStateByRequestId(requestId, state);
    }

    @Override
    public void updateBalanceAndPortion() {
        // selectionMapper.updateBalance(buyDTO.getAccountId(), buyDTO.getAmount());
        // 调用更新持仓接口 updatePositionPortion updatePositionFrozenPortion
        // 净值计算、申购费率计算
    }

    @Override
    public List<PortionVO> getUserPortion(Long userId) {
        List<PortionVO> list = selectionMapper.getUserPortion(userId);
        return list;
    }

    @Override
    public List<BuyRecordVO> getBuyRecordByDate(LocalDate date) {
        if(date.getDayOfWeek().getValue() == 1){
            return selectionMapper.getBuyRecord_1(date);
        }else if(date.getDayOfWeek().getValue() == 2){
            return selectionMapper.getBuyRecord_2(date);
        }else{
            return selectionMapper.getBuyRecord(date);
        }
    }
    @Override
    public List<SellRecordVO> getSellRecordByDate(LocalDate date) {
        if(date.getDayOfWeek().getValue() == 1){
            return selectionMapper.getSellRecord_1(date);
        }else if(date.getDayOfWeek().getValue() == 2){
            return selectionMapper.getSellRecord_2(date);
        }else{
            return selectionMapper.getSellRecord(date);
        }
    }
}

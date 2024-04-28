package com.hundsun.fund.service;

import com.hundsun.fund.mapper.SelectionMapper;
import com.hundsun.fund.selection.SelectionService;
import com.hundsun.fund.selection.dto.RecordDTO;
import com.hundsun.fund.selection.vo.RecordVO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

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
}
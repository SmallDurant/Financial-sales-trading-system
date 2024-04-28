package com.hundsun.fund.service;

import com.hundsun.fund.log.LogService;
import com.hundsun.fund.log.vo.LogRecordVO;
import com.hundsun.fund.mapper.LogMapper;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/28
 **/
@CloudComponent
@Slf4j
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;


    @Override
    public List<LogRecordVO> getLogRecord(Long start, Long size) {
        List<LogRecordVO> list = logMapper.getLogRecord(start, size);
        return list;
    }

    @Override
    public void AddLogRecord(Long EmployeeId, Integer type, String detail, LocalDateTime time) {
        logMapper.addLogRecord(EmployeeId, type, detail, time);
    }
}

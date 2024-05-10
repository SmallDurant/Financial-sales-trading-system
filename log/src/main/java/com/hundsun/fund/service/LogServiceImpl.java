package com.hundsun.fund.service;

import com.hundsun.fund.log.LogService;
import com.hundsun.fund.log.vo.LogRecordVO;
import com.hundsun.fund.mapper.LogMapper;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * @author: Dding
 * @date: 2024/04/28
 **/
@CloudComponent
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;


    @Override
    public List<LogRecordVO> getLogRecord(Long start, Long size) {

        return logMapper.getLogRecord(start, size);
    }

    @Override
    public Boolean AddLogRecord(Long employeeId, Integer type, String detail, LocalDateTime time) {

       return logMapper.addLogRecord(employeeId, type, detail, time) > 0;
    }
}

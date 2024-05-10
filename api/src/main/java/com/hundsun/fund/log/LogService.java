package com.hundsun.fund.log;

import com.hundsun.fund.log.vo.LogRecordVO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/28
 **/
@CloudService
public interface LogService {
    @CloudFunction("getLogRecord")
    List<LogRecordVO> getLogRecord(Long start, Long size);

    @CloudFunction("AddLogRecord")
    Boolean AddLogRecord(Long employeeId, Integer type, String detail, LocalDateTime time);
}

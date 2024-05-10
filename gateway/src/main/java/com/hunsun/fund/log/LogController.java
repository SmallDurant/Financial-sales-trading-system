package com.hunsun.fund.log;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.log.LogService;
import com.hundsun.fund.log.vo.LogRecordVO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import com.hunsun.fund.fund.PortionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/28
 **/
@RestController
@RequestMapping("/log")
public class LogController {

    private static final Logger log = LoggerFactory.getLogger(PortionController.class);
    @CloudReference
    private LogService logService;

    @GetMapping("/getRecord")
    public Result getRecord(@RequestParam Long start, @RequestParam Long size){

        log.info("查询从{start}数据的前{size}个记录");

        return Result.success(logService.getLogRecord(start, size));
    }

    @PostMapping("/addRecord")
    public Result addRecord(@RequestParam Long employeeId,
                          @RequestParam Integer type,
                          @RequestParam String detail, @RequestParam("time") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime time){

        log.info("增加记录");

        return Result.success(logService.AddLogRecord(employeeId, type, detail, time));
    }
}

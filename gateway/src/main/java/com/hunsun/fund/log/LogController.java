package com.hunsun.fund.log;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.log.LogService;
import com.hundsun.fund.log.vo.LogRecordVO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/28
 **/
@RestController
@RequestMapping("/log")
public class LogController {

    @CloudReference
    private LogService logService;

    @GetMapping("/getRecord")
    public Result getRecord(@RequestParam Long start, @RequestParam Long size){
        List<LogRecordVO> list = logService.getLogRecord(start, size);
        return Result.success(list);
    }

    // @PostMapping("/addRecord")
//    public void addRecord(Long EmployeeId, Integer type, String detail, LocalDateTime time){
//        logService.AddLogRecord(EmployeeId, type, detail, time);
//    }
}

package com.hunsun.fund.fund;


import com.hundsun.fund.api.Result;
import com.hundsun.fund.fund.NavService;
import com.hundsun.fund.fund.dto.NavDTO;
import com.hundsun.fund.log.LogService;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/nav")
public class NavController {
    private static final Logger log = LoggerFactory.getLogger(FundController.class);

    @CloudReference
    private NavService navService;

    @CloudReference
    private LogService logService;

    @GetMapping("/get")
    public Result getAllNavs() {
        log.info("获取所有净值信息");
        return Result.success(navService.findAllNavs());
    }

    @PostMapping("/create")
    public Result createNav(@RequestBody NavDTO navDTO) {
        log.info("创建新的净值信息");
        int res = navService.createNav(navDTO);
        if (res > 0) {
            return Result.success("创建成功");
        } else if(res == -1){
            return Result.error("已存在相同日期和ID的净值信息");
        }
        else return Result.error("创建失败");
    }

    @PutMapping("/update/{fundId}/{date}")
    public Result updateNav(@PathVariable Long fundId,
                            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                            @RequestBody NavDTO navDTO) {
        log.info("更新净值信息");
        Boolean res = navService.updateNav(fundId, date, navDTO);
        if (res) {
            //Boolean r = logService.AddLogRecord(1L,7,"更新某基金净值", LocalDateTime.now());
            return Result.success("净值信息更新成功");
        } else {
            return Result.error("净值信息更新失败");
        }
    }

    @GetMapping("/find/{fundId}")
    public Result getNavsByFundId(@PathVariable Long fundId) {
        log.info("根据基金ID获取净值信息");
        List<NavDTO> res = navService.findNavById(fundId);
        if(res == null || res.isEmpty()){
            return Result.error("不存在该基金");
        }
        return Result.success(res);
    }

    @GetMapping("/by-date/{date}")
    //public Result getNavsByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
    public Result getNavsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date) {
        log.info("根据日期获取净值信息");
        List<NavDTO> res =navService.findNavByDate(date);
        if(res == null || res.isEmpty()){
            return Result.error("日期不合法");
        }
        return Result.success(res);
    }

    @GetMapping("/by-fund-date/{fundId}/{date}")
    public Result getNavByDateAndId(@PathVariable Long fundId,
                                    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("根据日期和ID获取净值信息");
        NavDTO nav = navService.findNavByDateAndID(fundId, date);
        if (nav != null) {
            return Result.success(nav);
        } else {
            return Result.error("未找到对应的净值信息");
        }
    }
}

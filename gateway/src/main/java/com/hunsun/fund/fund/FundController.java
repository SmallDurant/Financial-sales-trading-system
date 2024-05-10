package com.hunsun.fund.fund;


import com.hundsun.fund.api.Result;
import com.hundsun.fund.fund.FundService;
import com.hundsun.fund.fund.dto.FundDTO;
import com.hundsun.fund.log.LogService;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/funds") // URL前缀，所有请求都是 /funds 开头
public class FundController {
    private static final Logger log = LoggerFactory.getLogger(FundController.class);

    @CloudReference
    private FundService fundService;
    @CloudReference
    private LogService logService;

    @GetMapping("/get") // 对应HTTP GET，用于获取所有基金信息
    public Result getAllFunds() {

        log.info("获取所有未删除基金信息");

        return  Result.success(fundService.findAllFunds());
    }

    @GetMapping("/getAll") // 对应HTTP GET，用于获取所有基金信息
    public Result getAll() {

        log.info("获取所有包括未删除基金信息");

        return  Result.success(fundService.findAll());
    }

    @GetMapping("/get/{fundId}") // 对应HTTP GET，用于获取指定基金的信息
    public Result getFundById(@PathVariable Long fundId) {

        log.info("获取fundId基金信息");

        return Result.success(fundService.findFundById(fundId));
    }

    @PostMapping // 对应HTTP POST，用于创建新的基金信息
    public Result createFund(@RequestBody FundDTO fundDTO) {

        log.info("创建新的基金信息");
        Boolean res = fundService.createFund(fundDTO);
        if(res){
            Boolean r = logService.AddLogRecord(1L,2,"新增了{fundId}指定基金信息", LocalDateTime.now());

            return Result.success("创建成功");
        }
        else return Result.error("创建失败");

    }

    @PutMapping("/update/{fundId}") // 对应HTTP PUT，用于更新指定基金信息
    public Result updateFund(@PathVariable Long fundId, @RequestBody FundDTO fundDTO) {

        log.info("更新指定基金信息");
        log.info(fundDTO.toString());
        Boolean res = fundService.updateFund(fundId, fundDTO);

        if(res){
            Boolean r = logService.AddLogRecord(1L,1,"更新了{fundId}指定基金信息", LocalDateTime.now());
            if(r) return Result.success("更新成功且管理员操作日志更新成功");
            else return Result.success("更新成功但管理员操作日志更新失败");
        }
        else return Result.error("更新失败");
    }

    @DeleteMapping("/delete/{fundId}") // 对应HTTP DELETE，用于删除指定基金信息
    public Result deleteFund(@PathVariable Long fundId) {

        log.info("删除指定基金");
        Boolean res = fundService.deleteFund(fundId);
        if(res){
            Boolean r = logService.AddLogRecord(1L,3,"删除了{fundId}指定基金信息", LocalDateTime.now());

            return Result.success("删除成功");
        }
        else return Result.error("删除失败");
    }

    @GetMapping("/getsumcount") // 对应HTTP GET，用于获取所有基金信息
    public Result getFundcount() {

        log.info("获取基金的数量");

        return  Result.success(fundService.findFundcount());
    }

}
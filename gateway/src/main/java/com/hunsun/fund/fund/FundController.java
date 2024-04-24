package com.hunsun.fund.fund;


import com.hundsun.fund.api.Result;
import com.hundsun.fund.fund.FundService;
import com.hundsun.fund.fund.dto.FundDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/funds") // URL前缀，所有请求都是 /funds 开头
public class FundController {
    private static final Logger log = LoggerFactory.getLogger(FundController.class);

    @CloudReference
    private FundService fundService;

    @GetMapping("/get") // 对应HTTP GET，用于获取所有基金信息
    public Result getAllFunds() {

        log.info("获取所有基金信息");

        return  Result.success(fundService.findAllFunds());
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
            return Result.success("更新成功");
        }
        else return Result.error("更新失败");
    }

    @DeleteMapping("/delete/{fundId}") // 对应HTTP DELETE，用于删除指定基金信息
    public Result deleteFund(@PathVariable Long fundId) {

        log.info("删除指定基金");
        Boolean res = fundService.deleteFund(fundId);
        if(res){
            return Result.success("删除成功");
        }
        else return Result.error("删除失败");
    }
}
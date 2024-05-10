package com.hunsun.fund.fund;


import com.hundsun.fund.fund.FundToManagerService;
import com.hundsun.fund.fund.dto.FundToManagerDTO;
import com.hundsun.fund.log.LogService;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.hundsun.fund.api.Result;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/fundToManager")
public class FundToManagerController {

    private static final Logger log = LoggerFactory.getLogger(FundToManagerController.class);

    @CloudReference
    private FundToManagerService fundToManagerService;

    @CloudReference
    private LogService logService;

    @GetMapping("/findByFundId/{fundId}")
    public Result findByFundId(@PathVariable Long fundId) {

        log.info("获取某基金的所有基金经理");

        List<FundToManagerDTO> fundToManagers = fundToManagerService.findByFundId(fundId);
        if (!fundToManagers.isEmpty()) {
            return Result.success(fundToManagers);
        } else {
            return Result.error("没有找到相关基金经理信息");
        }
    }

    @GetMapping("/findByManagerId/{managerId}")
    public Result findByManagerId(@PathVariable Long managerId) {

        log.info("获取某基金经理的所有基金及对应信息");

        List<FundToManagerDTO> fundToManagers = fundToManagerService.findByManagerId(managerId);
        if (!fundToManagers.isEmpty()) {
            return Result.success(fundToManagers);
        } else {
            return Result.error("没有找到相关基金信息");
        }
    }

    @PutMapping("/updateFundToManager/{id}")
    public Result updateFundToManager(@PathVariable Long id, @RequestBody FundToManagerDTO fundToManager) {

        log.info("更新信息");

        Boolean res = fundToManagerService.updateFundToManager(id, fundToManager);
        if (res) {
            Boolean r = logService.AddLogRecord(1L,4,"修改了某基金的基金经理的信息", LocalDateTime.now());

            return Result.success("更新成功");
        } else {
            return Result.error("更新失败");
        }
    }

    @PostMapping("/addFundToManager")
    public Result addFundToManager(@RequestBody FundToManagerDTO fundToManager) {

        log.info("添加信息");

        Boolean res = fundToManagerService.addFundToManager(fundToManager);
        if (res) {
            Boolean r = logService.AddLogRecord(1L,4,"新增了某基金的基金经理", LocalDateTime.now());
            return Result.success("添加成功");
        } else {
            return Result.error("添加失败");
        }
    }
}

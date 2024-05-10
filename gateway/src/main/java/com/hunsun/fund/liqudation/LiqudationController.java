package com.hunsun.fund.liqudation;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.liquidation.LiqudationService;
import com.hundsun.fund.liquidation.entity.NetValueUpdate;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import com.hunsun.fund.fund.ManagerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/liqudation")
public class LiqudationController {
    @CloudReference
    private LiqudationService liqudationService;

    private static final Logger log = LoggerFactory.getLogger(ManagerController.class);
    @PostMapping("/updateNetValue")
    public Result updateNetValue(@RequestBody List<NetValueUpdate> netValueUpdates) {

        log.info("更新净值");

        if(liqudationService.updateNetValue(netValueUpdates)){
            return Result.success("净值更新成功");
        }
        else return Result.error("净值更新失败");
    }

    @PostMapping("/settleSubscription")
    public Result settleSubscription() {

        log.info("清算申购基金");
        if(liqudationService.settleSubscription()){
            return Result.success("申购基金清算成功");
        }
        else return Result.error("申购基金清算失败");
    }

    @PostMapping("/settleRedemption")
    public Result settleRedemption() {

        log.info("清算赎回基金");

        if(liqudationService.settleRedemption()){
            return Result.success("赎回基金清算成功");
        }
        else return Result.error("赎回基金清算失败");
    }
}

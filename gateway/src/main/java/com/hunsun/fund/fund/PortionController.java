package com.hunsun.fund.fund;

import com.hundsun.fund.fund.FundService;
import com.hundsun.fund.fund.PortionService;
import com.hundsun.fund.api.Result;
import com.hundsun.fund.fund.dto.FundportionDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/portion")
public class PortionController {
    private static final Logger log = LoggerFactory.getLogger(PortionController.class);
    @CloudReference
    private PortionService portionService;

    @GetMapping("/get/{userId}")
    public Result getUserPortions(@PathVariable Long userId) {
        log.info("获取用户ID为 {} 的所有份额信息", userId);
        return Result.success(portionService.findPortion(userId));
    }

    @PostMapping("/create/{userId}/{accountId}/{fundId}/{portion}")
    public Result createPortion(
            @PathVariable Long userId,
            @PathVariable Long accountId,
            @PathVariable Long fundId,
            @PathVariable BigDecimal portion) {

        log.info("创建新的份额记录");

        int res = portionService.createPortion(userId, accountId, fundId, portion);
        log.info(String.valueOf(res));
        if(res == -1){
            return Result.success("该份额已存在");
        }
        else if(res == 0)return Result.error("创建份额失败");
        else return Result.success("创建份额成功");

    }

    @PostMapping("/updatePosition/{userId}/{accountId}/{fundId}/{additionalPortion}")
    public Result updatePositionPortion(
            @PathVariable Long userId,
            @PathVariable Long accountId,
            @PathVariable Long fundId,
            @PathVariable BigDecimal additionalPortion) {
        log.info("更新份额持有量");

        Boolean res = portionService.updatePositionPortion(userId, accountId, fundId, additionalPortion);

        if(res){
            return Result.success("更新持有量成功");
        }
        else return Result.error("更新持有量失败");
    }

//    @PostMapping("/updateFrozen/{userId}/{accountId}/{fundId}/{additionalFrozenPortion}")
    @PostMapping("/updateFrozen")
    public Result updatePositionFrozenPortion(
            @RequestParam Long userId,
            @RequestParam Long accountId,
            @RequestParam Long fundId,
            @RequestParam BigDecimal additionalFrozenPortion) {
        log.info("更新份额冻结量");
        int res = portionService.updatePositionFrozenPortion(userId, accountId, fundId, additionalFrozenPortion);

        if(res > 0){
            return Result.success("更新冻结量成功");
        }
        else if(res == 0)return Result.error("更新冻结量失败");
        else return Result.error("冻结量份额输入有误");
    }

    @PostMapping("/cutFrozen")
    public Result cutPositionFrozenPortion(
            @RequestParam Long userId,
            @RequestParam Long accountId,
            @RequestParam Long fundId,
            @RequestParam BigDecimal cutFrozenPortion) {
        log.info("申购成功，删减冻结量");
        Boolean res = portionService.cutPositionFrozenPortion(userId, accountId, fundId, cutFrozenPortion);

        if(res){
            return Result.success("申购完成，冻结删除成功");
        }
        else return Result.error("申购失败，冻结删除失败");
    }
}

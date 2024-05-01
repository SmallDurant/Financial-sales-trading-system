package com.hunsun.fund.transaction;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.transaction.TransactionService;
import com.hundsun.fund.transaction.dto.BuyDTO;
import com.hundsun.fund.transaction.dto.CancelDTO;
import com.hundsun.fund.transaction.dto.SellDTO;
import com.hundsun.fund.transaction.vo.UserInfoVO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    // TODO: 申购赎回认证

    @CloudReference
    private TransactionService transactionService;

    @GetMapping("/getNameByCode/{fundCode}")
    public Result getFundNameByFundCode(@PathVariable String fundCode){
        String fundName = transactionService.getFundNameByFundCode(fundCode);
        return Result.success(fundName);
    }

    @GetMapping("/getCodeByName/{fundName}")
    public Result getFundCodeByFundCode(@PathVariable String fundName){
        String fundCode = transactionService.getFundCodeByFundName(fundName);
        return Result.success(fundCode);
    }

    @GetMapping("/getUserInfo/{userId}")
    public Result getUserInfoByUserId(@PathVariable Long userId){
        UserInfoVO userInfoVO = transactionService.getUserInfoByUserId(userId);
        return Result.success();
    }



    @PostMapping("/buy")
    public Result buyFund(@RequestBody BuyDTO buyDTO){
        transactionService.buyFund(buyDTO);
        return Result.success();
    }

    @PostMapping("/sell")
    public Result sellFund(@RequestBody SellDTO sellDTO){
        transactionService.sellFund(sellDTO);
        return Result.success();
    }

    @DeleteMapping("/cancel/{requestId}")
    public Result cancelOrder(@PathVariable Long requestId,
                              @RequestBody CancelDTO cancelDTO){
        transactionService.cancelOrder(requestId);
        transactionService.addCancelRecord(cancelDTO);
        return Result.success();
    }

}

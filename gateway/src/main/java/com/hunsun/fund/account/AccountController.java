package com.hunsun.fund.account;

import com.hundsun.fund.account.AccountService;
import com.hundsun.fund.account.dto.AccountSaveDTO;
import com.hundsun.fund.account.dto.AccountSearchDTO;
import com.hundsun.fund.account.dto.AccountTransferDTO;
import com.hundsun.fund.account.entity.Account;
import com.hundsun.fund.api.Result;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * @Date 2024/4/30 下午3:25
 * @Description
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @CloudReference
    private AccountService accountService;

    @PostMapping("/add")
    public Result add(@RequestBody Account account){
        return Result.success(accountService.addAccount(account));
    }

    @PostMapping("/unbind")
    public Result unbindAccount(@RequestParam Long accountId){
        return Result.state(accountService.unbindAccount(accountId));
    }

    @PostMapping("/getAll")
    public Result getAccount(@RequestBody AccountSearchDTO accountSearchDTO){
        return Result.success(accountService.selectAllAccount(accountSearchDTO));
    }

    @PostMapping("/get")
    public Result getAvailableAccount(@RequestBody AccountSearchDTO accountSearchDTO){
       Result r =  Result.success(accountService.selectAvailableAccount(accountSearchDTO));
        return r;
    }

    @PostMapping("/transferIn")
    public Result transferIn(@RequestBody AccountTransferDTO accountTransferDTO){
        return Result.state(accountService.transferIn(accountTransferDTO));
    }

    @PostMapping("/transferOut")
    public Result transferOut(@RequestBody AccountTransferDTO accountTransferDTO){
        return Result.state(accountService.transferOut(accountTransferDTO));
    }

    @PostMapping("/getBalance")
    public Result getBalance(@RequestBody AccountSearchDTO accountSearchDTO){
        return Result.success(accountService.getAccountBalance(accountSearchDTO));
    }
}

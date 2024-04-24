package com.hunsun.fund.transaction;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.user.TransactionService;
import com.hundsun.fund.transaction.dto.TransactionRecordDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @CloudReference
    private TransactionService transactionService;

    @RequestMapping("/record")
    public Result record(@RequestBody TransactionRecordDTO transactionRecordDTO){
        return Result.success(transactionService.getTransactionRecord(transactionRecordDTO));
    }


}

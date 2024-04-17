package com.hundsun.controller;

import com.hundsun.dto.TransactionRecordDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import com.hundsun.reporting.TransactionRecordService;
import com.hundsun.result.Result;
import com.hundsun.vo.TransactionRecordVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/16
 **/
@RestController
@RequestMapping("/reporting")
@Slf4j
public class TransactionRecordController {
    @CloudReference
    private TransactionRecordService transactionRecordService;

    @GetMapping("/record")
    public Result<List<TransactionRecordVO>> getRecord(TransactionRecordDTO transactionRecordDTO){
        log.info("根据条件查询交易记录");
        List<TransactionRecordVO> list = transactionRecordService.getRecord(transactionRecordDTO);
        return Result.success(list);
    }
}
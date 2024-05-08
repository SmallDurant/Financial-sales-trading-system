package com.hunsun.fund.selection;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.selection.SelectionService;
import com.hundsun.fund.selection.dto.RecordDTO;
import com.hundsun.fund.selection.vo.BuyRecordVO;
import com.hundsun.fund.selection.vo.PortionVO;
import com.hundsun.fund.selection.vo.SellRecordVO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@RestController
@RequestMapping("/selection")
public class SelectionController {

    @CloudReference
    private SelectionService selectionService;

    @PostMapping("/record")
    public Result record(@RequestBody RecordDTO recordDTO){
        return Result.success(selectionService.getTransactionRecord(recordDTO));
    }

    @PutMapping("/confirmRecord")
    public Result confirmRecord(@RequestParam Long requestId){
        selectionService.updateStateByRequestId(requestId, 2);
        // selectionService.updateBalanceAndPortion();
        return Result.success();
    }

    @PutMapping("/rejectRecord")
    public Result rejectRecord(@RequestParam Long requestId){
        selectionService.updateStateByRequestId(requestId, 4);
        return Result.success();
    }

    @GetMapping("/portion/{userId}")
    public Result portion(@PathVariable Long userId){
        List<PortionVO> list = selectionService.getUserPortion(userId);
        return Result.success(list);
    }

    @GetMapping("/buyRecord")
    public Result buyRecord(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        List<BuyRecordVO> list = selectionService.getBuyRecordByDate(date);
        return Result.success(list);
    }

    @GetMapping("/sellRecord")
    public Result sellRecord(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        List<SellRecordVO> list = selectionService.getSellRecordByDate(date);
        return Result.success(list);
    }
}

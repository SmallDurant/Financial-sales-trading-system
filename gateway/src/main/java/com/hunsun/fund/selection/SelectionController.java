package com.hunsun.fund.selection;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.selection.SelectionService;
import com.hundsun.fund.selection.dto.RecordDTO;
import com.hundsun.fund.selection.vo.PortionVO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/record")
    public Result record(@RequestBody RecordDTO recordDTO){
        // TODO: 数组返回
        return Result.success(selectionService.getTransactionRecord(recordDTO));
    }

    @GetMapping("/portion/{userId}")
    public Result portion(@PathVariable Long userId){
        List<PortionVO> list = selectionService.getUserPortion(userId);
        return Result.success(list);
    }
}

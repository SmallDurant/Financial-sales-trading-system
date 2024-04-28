package com.hunsun.fund.selection;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.selection.SelectionService;
import com.hundsun.fund.selection.dto.RecordDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@RestController
@RequestMapping("/selection")
public class SelectionController {

    @CloudReference
    private SelectionService selectionService;

    @RequestMapping("/record")
    public Result record(@RequestBody RecordDTO recordDTO){
        return Result.success(selectionService.getTransactionRecord(recordDTO));
    }


}

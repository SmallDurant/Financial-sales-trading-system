package com.hundsun.fund.selection;

import com.hundsun.fund.selection.dto.RecordDTO;
import com.hundsun.fund.selection.vo.PortionVO;
import com.hundsun.fund.selection.vo.RecordVO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@CloudComponent
public interface SelectionService {

    @CloudFunction("getTransactionRecord")
    RecordVO getTransactionRecord(RecordDTO recordDTO);

    @CloudFunction("getUserPortion")
    PortionVO getUserPortion(Long userId);
}

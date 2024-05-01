package com.hundsun.fund.selection;

import com.hundsun.fund.selection.dto.RecordDTO;
import com.hundsun.fund.selection.vo.PortionVO;
import com.hundsun.fund.selection.vo.RecordVO;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@CloudService
public interface SelectionService {

    @CloudFunction("getTransactionRecord")
    RecordVO getTransactionRecord(RecordDTO recordDTO);

    @CloudFunction("getUserPortion")
    List<PortionVO> getUserPortion(Long userId);
}

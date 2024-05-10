package com.hundsun.fund.selection;

import com.hundsun.fund.selection.dto.RecordDTO;
import com.hundsun.fund.selection.vo.*;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@CloudService
public interface SelectionService {

    @CloudFunction("getTransactionRecord")
    List<RecordVO> getTransactionRecord(RecordDTO recordDTO);

    @CloudFunction("getInfoRecord")
    InfoVO getInfoRecord(Long requestId);

    @CloudFunction("updateStateByRequestId")
    void updateStateByRequestId(Long requestId, Integer state);

    @CloudFunction("updateBalanceAndPortion")
    void updateBalanceAndPortion();

    @CloudFunction("getUserPortion")
    List<PortionVO> getUserPortion(Long userId);

    @CloudFunction("getBuyRecordByDate")
    List<BuyRecordVO> getBuyRecordByDate(LocalDate date);

    @CloudFunction("getSellRecordByDate")
    List<SellRecordVO> getSellRecordByDate(LocalDate date);
}

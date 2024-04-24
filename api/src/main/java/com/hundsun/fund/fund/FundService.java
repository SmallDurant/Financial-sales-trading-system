package com.hundsun.fund.fund;

import com.hundsun.fund.fund.dto.FundDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;


import java.util.List;

import org.springframework.web.bind.annotation.*;

@CloudService
public interface FundService {

    //找所有未删除的基金
    @CloudFunction("findAllFunds")
    List<FundDTO> findAllFunds();

    //根据指定基金ID查找
    @CloudFunction("findFundById")
    FundDTO findFundById(@PathVariable Long fundId);

    //创建新的基金
    @CloudFunction("createFund")
    Boolean createFund(@RequestBody FundDTO fund);

    //更新指定ID基金
    @CloudFunction("updateFund")
    Boolean updateFund(@PathVariable Long fundId, @RequestBody FundDTO fundDTO);

    //删除指定基金
    @CloudFunction("deleteFund")
    Boolean deleteFund(@PathVariable Long fundId);
}

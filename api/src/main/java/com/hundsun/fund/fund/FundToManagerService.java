package com.hundsun.fund.fund;

import com.hundsun.fund.fund.dto.FundToManagerDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;
import java.util.List;
@CloudService
public interface FundToManagerService {
    @CloudFunction("findByFundId")
    List<FundToManagerDTO> findByFundId(Long fundId);

    @CloudFunction("findByManagerId")
    List<FundToManagerDTO> findByManagerId(Long managerId);

    @CloudFunction("updateFundToManager")
    Boolean updateFundToManager(Long id, FundToManagerDTO fundToManager);

    @CloudFunction("addFundToManager")
    Boolean addFundToManager(FundToManagerDTO fundToManager);

}

package com.hundsun.fund.fund;

import com.hundsun.fund.fund.dto.ManagerDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@CloudService
public interface ManagerService {
    @CloudFunction("findManagerById")
    ManagerDTO findManagerById(@PathVariable Long managerId);
    @CloudFunction("createManager")
    Boolean createManager(@RequestBody ManagerDTO managerDTO);
    @CloudFunction("updateManager")
    Boolean updateManager(@PathVariable Long managerId,@RequestBody ManagerDTO managerDTO);
    @CloudFunction("deleteManager")
    Boolean deleteManager(@PathVariable Long managerId);
}

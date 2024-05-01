package com.hundsun.fund.selection;

import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@CloudService
public interface HomepageDataService {

    @CloudFunction("getConfirmedNum")
    Integer getConfirmedNum();

    @CloudFunction("getUnconfirmedNum")
    Integer getUnconfirmedNum();

    @CloudFunction("getBuyNum")
    Integer getBuyNum();

    @CloudFunction("getSellNum")
    Integer getSellNum();

    @CloudFunction("getCancelNum")
    Integer getCancelNum();

    @CloudFunction("getFundNum")
    Integer getFundNum();

}

package com.hundsun.fund.user;

import com.hundsun.fund.user.dto.SysLoginDTO;
import com.hundsun.fund.user.vo.SysUserVO;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

/**
 * @Author
 * @Date 2024/4/19 14:29
 * @Description
 */
@CloudService
public interface UserService {
    @CloudFunction("userLogin")
    SysUserVO userLogin(SysLoginDTO user);
}

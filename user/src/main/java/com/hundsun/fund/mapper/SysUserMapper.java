package com.hundsun.fund.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hundsun.fund.user.user.dto.SysUserInfoDTO;
import com.hundsun.fund.user.user.entity.SysUser;
import com.hundsun.fund.user.user.vo.SysUserInfoVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author
 * @Date 2024/4/9 13:06
 * @Description
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    default SysUser selectByAccount(String account) {
        return selectOne(new QueryWrapper<SysUser>().eq("account", account));
    }

    SysUserInfoVO getInfo(Long userId);

    boolean updateInfo(SysUserInfoDTO sysUserInfoDTO);

}

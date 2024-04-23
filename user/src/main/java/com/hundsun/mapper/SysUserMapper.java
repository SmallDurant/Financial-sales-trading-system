package com.hundsun.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hundsun.fund.user.dto.SysUserInfoDTO;
import com.hundsun.fund.user.entity.SysUser;
import com.hundsun.fund.user.vo.SysUserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    SysUserInfoVO getUserInfo(Long userId);

    Boolean updateUserInfo(SysUserInfoDTO userInfoDTO);

    @Select("SELECT transaction_password FROM tuser WHERE id = #{userid}")
    String getTransactionPassword(Long userid);
}

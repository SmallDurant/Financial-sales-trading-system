package com.hundsun.fund.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hundsun.fund.user.dto.SysUserInfoDTO;
import com.hundsun.fund.user.entity.SysUser;
import com.hundsun.fund.user.vo.SysUserInfoVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    @Select("SELECT transaction_password FROM tuser WHERE tuser.user_id = #{userid}")
    String getTransactionPassword(Long userid);

    @Insert("INSERT INTO taccount(user_id,card_password) values (#{userId},#{cardPassword})")
    void insertAccount(@Param("userId") Long userId, @Param("cardPassword") String cardPassword);
}

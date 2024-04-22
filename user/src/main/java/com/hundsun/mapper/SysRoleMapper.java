package com.hundsun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hundsun.fund.user.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author
 * @Date 2024/4/11 11:57
 * @Description
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("SELECT id,`key`,name FROM trole WHERE id in (select role_id from tuserrole where user_id = #{userId})")
    List<SysRole> getUserRole(Long userId);

    @Select("SELECT id,`key`,name FROM trole WHERE id in (select role_id from temployeerole where employee_id = #{userId})")
    List<SysRole> getEmployeeRole(Long userId);
}

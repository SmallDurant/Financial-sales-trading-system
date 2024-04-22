package com.hundsun.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hundsun.fund.user.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * @Date 2024/4/11 11:57
 * @Description
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

     default List<SysPermission> getPermission(Long[] roleIds){
        StringBuilder sb=new StringBuilder();
        for (Long roleId : roleIds) {
            sb.append(roleId).append(",");
        }
        if(sb.length()>1) sb.deleteCharAt(sb.length()-1);
        if (sb.length() == 0) return new ArrayList<>();
       return this.selectList(new QueryWrapper<SysPermission>().inSql("id","SELECT permission_id FROM trolepermission WHERE role_id in ("+sb.toString()+")"));
    }
}

package com.hundsun.fund.user.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date 2024/4/11 11:55
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tpermission")
public class SysPermission{
    private Long id;
    private String name;
    private String perm;
}

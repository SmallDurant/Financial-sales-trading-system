package com.hundsun.fund.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date 2024/4/11 11:54
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("trole")
public class SysRole {
    private Long id;
    private String key;
    private String name;
}

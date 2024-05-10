package com.hundsun.fund.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @Author
 * @Date 2024/4/19 16:54
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("temployee")
public class Employee {
    @TableId(type = IdType.AUTO)
    private Long employeeId;
    private String account;
    private String password;
    private String name;
    private String phoneNumber;
    private String department;
    private Timestamp lastLogin;
}

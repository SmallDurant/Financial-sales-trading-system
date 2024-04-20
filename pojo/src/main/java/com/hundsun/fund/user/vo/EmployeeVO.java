package com.hundsun.fund.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date 2024/4/19 17:13
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeVO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String department;
    private String token;
}

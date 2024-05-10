package com.hundsun.fund.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date 2024/4/29 下午9:55
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfoVO {
    private Long id;
    private String account;
    private String name;
    private String phoneNumber;
    private String department;
}

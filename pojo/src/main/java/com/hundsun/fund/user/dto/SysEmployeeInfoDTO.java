package com.hundsun.fund.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date 2024/4/23 16:57
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysEmployeeInfoDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String department;
}

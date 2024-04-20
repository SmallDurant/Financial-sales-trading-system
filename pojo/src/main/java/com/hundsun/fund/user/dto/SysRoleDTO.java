package com.hundsun.fund.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author
 * @Date 2024/4/13 14:32
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleDTO {
    private Long userId;
    private List<Long> roleIds;
}

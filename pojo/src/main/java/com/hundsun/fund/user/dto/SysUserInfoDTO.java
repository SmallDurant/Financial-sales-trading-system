package com.hundsun.fund.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date 2024/4/19 17:04
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserInfoDTO {
    private String name;//用户名
    private String email;//邮箱
    private String phoneNumber;//手机号
    private String province;//省份
    private String city;//城市
    private String address;//地址
    private int occupation;//职业
    private int industry;//行业
    private String workUnit;//工作单位
    private int educationalBackground;//学历
}

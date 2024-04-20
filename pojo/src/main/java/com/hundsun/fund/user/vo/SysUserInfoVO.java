package com.hundsun.fund.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author
 * @Date 2024/4/19 16:50
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserInfoVO {
    private String name;//用户名
    private String idNumber;//身份证号码
    private String email;//邮箱
    private String phoneNumber;//手机号
    private String province;//省份
    private String city;//城市
    private String address;//地址
    private int occupation;//职业
    private int industry;//行业
    private String workUnit;//工作单位
    private int educationalBackground;//学历
    private boolean isDishonest;//是否失信
    private int customerType;//客户类型
}

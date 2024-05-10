package com.hundsun.fund.user.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type = IdType.AUTO)
    private String userId;//用户id
    private String name;//用户名
    private String email;//邮箱
    private String phoneNumber;//手机号
    private String province;//省份
    private String city;//城市
    private String address;//地址
    private Integer occupation;//职业
    private Integer industry;//行业
    private String workUnit;//工作单位
    private Integer educationalBackground;//学历
}

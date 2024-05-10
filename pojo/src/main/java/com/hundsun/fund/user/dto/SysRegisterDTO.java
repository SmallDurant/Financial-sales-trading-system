package com.hundsun.fund.user.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Timestamp;

/**
 * @Author
 * @Date 2024/4/19 16:46
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRegisterDTO {
    @TableId(value = "id", type = IdType.AUTO)
    @Null(message = "id 不能传值")
    private Long id;//ID
    @NotNull(message = "账号不能为空")
    private String account;//账号
    @NotNull(message = "密码不能为空")
    private String password;//密码
    @NotNull(message = "用户名不能为空")
    private String name;//用户名
    @NotNull(message = "身份证号码不能为空")
    private String idNumber;//身份证号码
    @NotNull(message = "邮箱不能为空")
    private String email;//邮箱
    @NotNull(message = "手机号不能为空")
    private String phoneNumber;//手机号
    @NotNull(message = "省份不能为空")
    private String province;//省份
    @NotNull(message = "城市不能为空")
    private String city;//城市
    @NotNull(message = "地址不能为空")
    private String address;//地址
    @NotNull(message = "职业不能为空")
    private Integer occupation;//职业
    @NotNull(message = "从事行业不能为空")
    private Integer industry;//行业
    @NotNull(message = "工作单位不能为空")
    private String workUnit;//工作单位
    @NotNull(message = "学历不能为空")
    private Integer educationalBackground;//学历
    @NotNull(message = "信用情况不能为空")
    private Boolean isDishonest;//是否失信
    @NotNull(message = "客户类型不能为空")
    private int customerType;//客户类型
    @NotNull(message = "交易密码不能为空")
    private String transactionPassword;//交易密码
    @NotNull(message = "风险等级不能为空")
    private Integer riskProfile;//风险等级
}

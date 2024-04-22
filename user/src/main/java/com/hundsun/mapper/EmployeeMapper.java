package com.hundsun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hundsun.fund.user.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author
 * @Date 2024/4/19 16:53
 * @Description
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}

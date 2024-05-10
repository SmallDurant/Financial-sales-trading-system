package com.hundsun.fund.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hundsun.fund.user.dto.SysEmployeeInfoDTO;
import com.hundsun.fund.user.entity.Employee;
import com.hundsun.fund.user.vo.EmployeeInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author
 * @Date 2024/4/19 16:53
 * @Description
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    Boolean updateEmployeeInfo(SysEmployeeInfoDTO sysEmployeeInfoDTO);

    @Select("SELECT employee_id,account,name,phone_number,department FROM temployee WHERE employee_id = #{employeeId}")
    EmployeeInfoVO getEmployeeInfo(Long employeeId);
}

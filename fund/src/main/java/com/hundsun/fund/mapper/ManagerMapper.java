package com.hundsun.fund.mapper;

import com.hundsun.fund.fund.dto.ManagerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ManagerMapper {

    ManagerDTO findManagerById(@Param("managerId")Long managerId);

    int createManager(@Param("managerDTO")ManagerDTO managerDTO);


    int updateManager(@Param("managerId")Long managerId,@Param("managerDTO") ManagerDTO managerDTO);


    int deleteManager(@Param("managerId")Long managerId);
}

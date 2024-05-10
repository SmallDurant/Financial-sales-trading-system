package com.hundsun.fund.service;

import com.hundsun.fund.fund.ManagerService;
import com.hundsun.fund.fund.dto.ManagerDTO;
import com.hundsun.fund.mapper.ManagerMapper;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;

@CloudComponent
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public ManagerDTO findManagerById(Long managerId) {

        return managerMapper.findManagerById(managerId);
    }

    @Override
    public Boolean createManager(ManagerDTO managerDTO) {


        return managerMapper.createManager(managerDTO) > 0;
    }

    @Override
    public Boolean updateManager(Long managerId, ManagerDTO managerDTO) {

        return managerMapper.updateManager(managerId, managerDTO) > 0;
    }

    @Override
    public Boolean deleteManager(Long managerId) {

        return managerMapper.deleteManager(managerId) > 0;
    }
}

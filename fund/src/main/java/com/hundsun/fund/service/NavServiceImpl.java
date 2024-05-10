package com.hundsun.fund.service;


import com.hundsun.fund.fund.NavService;
import com.hundsun.fund.fund.dto.NavDTO;

import com.hundsun.fund.mapper.NavMapper;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@CloudComponent
public class NavServiceImpl implements NavService {

    @Autowired
    private NavMapper navMapper;

    @Override
    public int createNav(NavDTO navDTO) {
        long fundId = navDTO.getFundId();
        LocalDate date = navDTO.getDate();
        if(navMapper.findNavByDateAndID(fundId, date) != null){
            return -1;
        }
        else return navMapper.createNav(navDTO);
    }

    @Override
    public Boolean updateNav(Long fundId, LocalDate date, NavDTO navDTO) {

        return navMapper.updateNav(fundId, date, navDTO) > 0;
    }

    @Override
    public List<NavDTO> findAllNavs() {

        return navMapper.findAllNavs();
    }

    @Override
    public List<NavDTO> findNavById(Long fundId) {

        return navMapper.findNavById(fundId);
    }

    @Override
    public List<NavDTO> findNavByDate(LocalDate date) {

        return navMapper.findNavByDate(date);
    }

    @Override
    public NavDTO findNavByDateAndID(Long fundId, LocalDate date) {

        return navMapper.findNavByDateAndID(fundId, date);
    }

}

package com.hundsun.fund.service;

import com.hundsun.fund.mapper.HomepageDataMapper;
import com.hundsun.fund.selection.HomepageDataService;
import com.hundsun.fund.selection.vo.HistoryDataVO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@CloudComponent
@Slf4j
public class HomepageDataServiceImpl implements HomepageDataService {

    @Resource
    private HomepageDataMapper homepageDataMapper;

    @Override
    public Integer getConfirmedNum() {
        LocalDate now = LocalDate.now();
        return homepageDataMapper.getConfirmedNum(now);
    }

    @Override
    public Integer getUnconfirmedNum() {
        LocalDate now = LocalDate.now();
        return homepageDataMapper.getUnconfirmedNum(now);
    }

    @Override
    public Integer getBuyNum() {
        LocalDate now = LocalDate.now();
        return homepageDataMapper.getBuyNum(now);
    }

    @Override
    public Integer getSellNum() {
        LocalDate now = LocalDate.now();
        return homepageDataMapper.getSellNum(now);
    }

    @Override
    public Integer getCancelNum() {
        LocalDate now = LocalDate.now();
        return homepageDataMapper.getCancelNum(now);
    }

    @Override
    public Integer getFundNum() {
        return homepageDataMapper.getFundNum();
    }

    @Override
    public List<HistoryDataVO> getBuyHistoryNum() {
        return homepageDataMapper.getBuyHistoryNum();
    }

    @Override
    public List<HistoryDataVO> getSellHistoryNum() {
        return homepageDataMapper.getSellHistoryNum();
    }

    @Override
    public List<HistoryDataVO> getCancelHistoryNum() {
        return homepageDataMapper.getCancelHistoryNum();
    }
}

package com.hundsun.fund.service;

import com.hundsun.fund.account.AccountService;
import com.hundsun.fund.account.dto.AccountTransferDTO;
import com.hundsun.fund.fund.NavService;
import com.hundsun.fund.fund.PortionService;
import com.hundsun.fund.fund.dto.NavDTO;
import com.hundsun.fund.liquidation.LiqudationService;
import com.hundsun.fund.liquidation.entity.NetValueUpdate;
import com.hundsun.fund.selection.SelectionService;
import com.hundsun.fund.selection.vo.BuyRecordVO;
import com.hundsun.fund.selection.vo.SellRecordVO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.expression.spel.ast.Selection;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class LiqudationServiceImpl  implements LiqudationService {

    @CloudReference
    private NavService navService;

    @CloudReference
    private PortionService portionService;

    @CloudReference
    private SelectionService selectionService;

    @CloudReference
    private AccountService accountService;
    @Override
    public Boolean updateNetValue(List<NetValueUpdate> netValueUpdates) {
        //获取上一工作日的日期
        LocalDate date = LocalDate.now();
        DayOfWeek day = date.getDayOfWeek();
        int ans = 0;
        switch (day) {
            case MONDAY:
                date =  date.minusDays(3); // 回退到上周五
            case SUNDAY:
                date =   date.minusDays(2); // 回退到上周五
            default:
                date =  date.minusDays(1); // 回退到前一天
        }
        for (NetValueUpdate update : netValueUpdates) {
            NavDTO navDTO = null;
            navDTO.setFundId(update.getFundId());
            navDTO.setCnav(update.getNetValue());
            navDTO.setNav(update.getNetValue());
            navDTO.setDate(date);
            if(navService.createNav(navDTO) > 0)ans++;
        }
        return ans == netValueUpdates.size();
    }

    @Override
    public Boolean settleSubscription() {
        //获取上一工作日的日期
        LocalDate date = LocalDate.now();
        DayOfWeek day = date.getDayOfWeek();
        int ans = 0;
        switch (day) {
            case MONDAY:
                date =  date.minusDays(3); // 回退到上周五
            case SUNDAY:
                date =   date.minusDays(2); // 回退到上周五
            default:
                date =  date.minusDays(1); // 回退到前一天
        }
        //找到当日申购订单列表
        List<BuyRecordVO>  buyRecordVO = selectionService.getBuyRecordByDate(LocalDate.now());
        for(BuyRecordVO d : buyRecordVO){
            Long fundID = Long.valueOf(d.getFundId());
            Long userID = Long.valueOf(d.getUserId());
            Long acountID = Long.valueOf(d.getAccountId());
            //找到净值
            NavDTO navDTO = navService.findNavByDateAndID(fundID,date);
            BigDecimal nav = navDTO.getNav();
            BigDecimal portion = d.getAmount().divide(nav, MathContext.DECIMAL128);

            ans = portionService.createPortion(userID,acountID,fundID,portion);
            if(ans == -1){
                portionService.updatePositionPortion(userID,acountID,fundID,portion);
            }
        }
        return true;
    }

    @Override
    public Boolean settleRedemption() {
        //获取上一工作日的日期
        LocalDate date = LocalDate.now();
        DayOfWeek day = date.getDayOfWeek();
        int ans = 0;
        switch (day) {
            case MONDAY:
                date =  date.minusDays(3); // 回退到上周五
            case SUNDAY:
                date =   date.minusDays(2); // 回退到上周五
            default:
                date =  date.minusDays(1); // 回退到前一天
        }
        //找到当日赎回订单列表
        List<SellRecordVO>  dto = selectionService.getSellRecordByDate(LocalDate.now());
        for(SellRecordVO d : dto){
            Long fundID = Long.valueOf(d.getFundId());
            Long userID = Long.valueOf(d.getUserId());
            Long acountID = Long.valueOf(d.getAccountId());
            //找到净值
            NavDTO navDTO = navService.findNavByDateAndID(fundID,date);
            BigDecimal nav = navDTO.getNav();
            BigDecimal amount = d.getAmount().multiply(nav);
            AccountTransferDTO accountTransferDTO = null;
            accountTransferDTO.setAmount(amount);
            //更新用户的账户
            accountService.transferIn(accountTransferDTO);
            //更新持仓
            portionService.cutPositionFrozenPortion(userID,acountID,fundID,amount);
        }
        return true;
    }
}

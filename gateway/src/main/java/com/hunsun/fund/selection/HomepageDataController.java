package com.hunsun.fund.selection;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.selection.HomepageDataService;
import com.hundsun.fund.selection.vo.DataVO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Dding
 * @date: 2024/04/24
 **/
@RestController
@RequestMapping("/homepageData")
public class HomepageDataController {

    @CloudReference
    private HomepageDataService homepageDataService;

    @GetMapping("/data")
    public Result getData(){
        DataVO dataVO = new DataVO();

        dataVO.setConfirmedNum(homepageDataService.getConfirmedNum());
        dataVO.setUnconfirmedNum(homepageDataService.getUnconfirmedNum());
        dataVO.setBuyNum(homepageDataService.getBuyNum());
        dataVO.setSellNum(homepageDataService.getSellNum());
        dataVO.setCancelNum(homepageDataService.getCancelNum());
        dataVO.setFundNum(homepageDataService.getFundNum());
        dataVO.setBuyHistoryNum(homepageDataService.getBuyHistoryNum());
        dataVO.setSellHistoryNum(homepageDataService.getSellHistoryNum());
        dataVO.setCancelHistoryNum(homepageDataService.getCancelHistoryNum());
        return Result.success(dataVO);
    }

//    @GetMapping("/confirmed")
//    public Result getConfirmedNum(){
//        return Result.success(homepageDataService.getConfirmedNum());
//    }
//
//    @GetMapping("/unconfirmed")
//    public Result getUnconfirmedNum(){
//        return Result.success(homepageDataService.getUnconfirmedNum());
//    }
//
//    @GetMapping("/buy")
//    public Result getBuyNum(){
//        return Result.success(homepageDataService.getBuyNum());
//    }
//
//    @GetMapping("/sell")
//    public Result getSellNum(){
//        return Result.success(homepageDataService.getSellNum());
//    }
//
//    @GetMapping("/cancel")
//    public Result getCancelNum(){
//        return Result.success(homepageDataService.getCancelNum());
//    }
//
//    @GetMapping("/fund")
//    public Result getFundNum(){
//        return Result.success(homepageDataService.getFundNum());
//    }

//    @GetMapping("/buyHistory")
//    public Result getBuyHistoryNum(){
//        return Result.success(homepageDataService.getBuyHistoryNum());
//    }
//
//    @GetMapping("/sellHistory")
//    public Result getSellHistoryNum(){
//        return Result.success(homepageDataService.getSellHistoryNum());
//    }
//
//    @GetMapping("/cancelHistory")
//    public Result getCancelHistoryNum(){
//        return Result.success(homepageDataService.getCancelHistoryNum());
//    }


}

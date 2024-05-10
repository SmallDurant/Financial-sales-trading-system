package com.hundsun.fund.mapper;

import com.hundsun.fund.fund.dto.FundDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/16
 **/

@Mapper
public interface FundMapper {


    List<FundDTO> findAllFunds();

    List<FundDTO> findAll();


    FundDTO findFundById(@Param("fundId") Long fundId);


    int createFund(FundDTO fund);


    int updateFund(@Param("fundId") Long fundId,@Param("fund") FundDTO fundDTO);



    int deleteFund(@Param("fundId") Long fundId);

}
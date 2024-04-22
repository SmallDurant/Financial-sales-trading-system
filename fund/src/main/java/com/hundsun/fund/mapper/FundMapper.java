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

   // @Select("SELECT * FROM tfund")
    List<FundDTO> findAllFunds();

    //@Select("SELECT * FROM tfund WHERE fund_id = #{fundId}")
    FundDTO findFundById(@Param("fundId") Long fundId);

    //@Insert("INSERT INTO tfund (fund_code, fund_name, fund_administrator, fund_trustee, fund_issuer, effective_date, fund_type, transaction_currency, fund_risk, fund_status, charge_way, purchase_rate, redemption_rate, management_fee_rate, custodian_fee_rate, fund_size, establishment_scale, fund_shares, min_subscription, nav, cnav, investment_philosophy, investment_scope, investment_strategy, operation_mode, fund_stage, is_delete) VALUES (#{fundCode}, #{fundName}, #{fundAdministrator}, #{fundTrustee}, #{fundIssuer}, #{effectiveDate}, #{fundType}, #{transactionCurrency}, #{fundRisk}, #{fundStatus}, #{chargeWay}, #{purchaseRate}, #{redemptionRate}, #{managementFeeRate}, #{custodianFeeRate}, #{fundSize}, #{establishmentScale}, #{fundShares}, #{minSubscription}, #{nav}, #{cnav}, #{investmentPhilosophy}, #{investmentScope}, #{investmentStrategy}, #{operationMode}, #{fundStage}, #{isDelete})")
    //@Options(useGeneratedKeys=true, keyProperty="fundId")
    int createFund(FundDTO fund);

    //@Update("UPDATE tfund SET fund_code = #{fundCode}, fund_name = #{fundName}, fund_administrator = #{fundAdministrator}, fund_trustee = #{fundTrustee}, fund_issuer = #{fundIssuer}, effective_date = #{effectiveDate}, fund_type = #{fundType}, transaction_currency = #{transactionCurrency}, fund_risk = #{fundRisk}, fund_status = #{fundStatus}, charge_way = #{chargeWay}, purchase_rate = #{purchaseRate}, redemption_rate = #{redemptionRate}, management_fee_rate = #{managementFeeRate}, custodian_fee_rate = #{custodianFeeRate}, fund_size = #{fundSize}, establishment_scale = #{establishmentScale}, fund_shares = #{fundShares}, min_subscription = #{minSubscription}, nav = #{nav}, cnav = #{cnav}, investment_philosophy = #{investmentPhilosophy}, investment_scope = #{investmentScope}, investment_strategy = #{investmentStrategy}, operation_mode = #{operationMode}, fund_stage = #{fundStage}, is_delete = #{isDelete} WHERE fund_id = #{fundId}")
    int updateFund(@Param("fundId") Long fundId,@Param("fund") FundDTO fund);


    //@Update("UPDATE tfund SET is_delete = true WHERE fund_id = #{fundId}")
    int deleteFund(@Param("fundId") Long fundId);

}
package com.hundsun.fund.account;

import com.hundsun.fund.account.dto.AccountSearchDTO;
import com.hundsun.fund.account.dto.AccountTransferDTO;
import com.hundsun.fund.account.entity.Account;
import com.hundsun.fund.account.vo.AccountSearchVO;
import com.hundsun.fund.account.vo.AccountVO;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author
 * @Date 2024/4/25 15:26
 * @Description
 */
@CloudService
public interface AccountService {

    @CloudFunction("addAccount")
    AccountSearchVO addAccount(Account account);

    @CloudFunction("unbindAccount")
    Boolean unbindAccount(Long accountId);

    @CloudFunction("selectAllAccount")
    List<AccountSearchVO> selectAllAccount(AccountSearchDTO accountSearchDTO);

    @CloudFunction("transferOut")
    Boolean transferOut(AccountTransferDTO accountTransferDTO);

    @CloudFunction("transferIn")
    Boolean transferIn(AccountTransferDTO accountTransferDTO);

    @CloudFunction("selectAvailableAccount")
    AccountVO selectAvailableAccount(AccountSearchDTO accountSearchDTO);

    @CloudFunction("getAccountBalance")
    BigDecimal getAccountBalance(AccountSearchDTO accountSearchDTO);
}

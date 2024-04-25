package com.hundsun.fund.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hundsun.fund.account.dto.AccountSaveDTO;
import com.hundsun.fund.account.dto.AccountSearchDTO;
import com.hundsun.fund.account.dto.AccountTransferDTO;
import com.hundsun.fund.account.entity.Account;
import com.hundsun.fund.account.vo.AccountSearchVO;
import com.hundsun.fund.exception.ServiceException;
import com.hundsun.fund.mapper.AccountMapper;
import com.hundsun.fund.utils.Assert;
import com.hundsun.fund.utils.BcryptUtil;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author
 * @Date 2024/4/25 15:21
 * @Description
 */
@CloudComponent
public class AccountServiceImpl {
    @Resource
    private AccountMapper accountMapper;

    public List<AccountSearchVO> selectAvailableAccount(AccountSearchDTO accountSearchDTO) {
        return accountMapper.selectAvailableAccount(accountSearchDTO);
    }

    public Boolean TransferIn(AccountTransferDTO accountTransferDTO) {
        Account account = accountMapper.selectById(accountTransferDTO.getAccountId());
        Assert.state(account.getStatus().equals(1), 400, "该账户已冻结");
        if (!BcryptUtil.match(accountTransferDTO.getCardPassword(), account.getCardPassword()))
            throw new ServiceException(400, "银行卡密码错误");
        account.setBalance(account.getBalance().add(accountTransferDTO.getAmount()));
        accountMapper.updateById(account);
        return true;
    }

    public Boolean TransferOut(AccountTransferDTO accountTransferDTO) {
        Account account = accountMapper.selectById(accountTransferDTO.getAccountId());
        Assert.state(account.getStatus().equals(1), 400, "该账户已冻结");
        if (!BcryptUtil.match(accountTransferDTO.getCardPassword(), account.getCardPassword()))
            throw new ServiceException(400, "银行卡密码错误");
        if (account.getBalance().compareTo(accountTransferDTO.getAmount()) < 0)
            throw new ServiceException(400, "余额不足");
        account.setBalance(account.getBalance().subtract(accountTransferDTO.getAmount()));
        accountMapper.updateById(account);
        return true;
    }

    public List<AccountSearchVO> selectAllAccount(AccountSearchDTO accountSearchDTO) {
        return accountMapper.selectAllAccount(accountSearchDTO);
    }

    public Account addAccount(Account account) {
        Assert.notNull(account.getBalance(), 400, "非法数据");
        accountMapper.insert(account);
        return account;
    }

    public Boolean unbindAccount(Long accountId) {
        return accountMapper.update(null, new UpdateWrapper<Account>().set("user_id", null).eq("account_id", accountId)) > 0;
    }
}

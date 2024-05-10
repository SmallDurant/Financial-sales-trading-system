package com.hundsun.fund.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hundsun.fund.account.AccountService;
import com.hundsun.fund.account.dto.AccountSaveDTO;
import com.hundsun.fund.account.dto.AccountSearchDTO;
import com.hundsun.fund.account.dto.AccountTransferDTO;
import com.hundsun.fund.account.entity.Account;
import com.hundsun.fund.account.vo.AccountSearchVO;
import com.hundsun.fund.account.vo.AccountVO;
import com.hundsun.fund.exception.ServiceException;
import com.hundsun.fund.mapper.AccountMapper;
import com.hundsun.fund.utils.Assert;
import com.hundsun.fund.utils.BcryptUtil;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author
 * @Date 2024/4/25 15:21
 * @Description
 */
@CloudComponent
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    public AccountVO selectAvailableAccount(AccountSearchDTO accountSearchDTO) {
        if ((accountSearchDTO.getAccount()==null||accountSearchDTO.getAccount().isEmpty()) &&
                (accountSearchDTO.getIdNumber()==null||accountSearchDTO.getIdNumber().isEmpty()) &&
                (accountSearchDTO.getPhoneNumber()==null||accountSearchDTO.getPhoneNumber().isEmpty()))
            throw new ServiceException(400, "查询条件不能全部为空");
        AccountVO accountVO = accountMapper.getAccountInfo(accountSearchDTO);
        accountVO.setAccounts(accountMapper.selectAvailableAccount(accountSearchDTO));
        return accountVO;
    }

    public BigDecimal getAccountBalance(AccountSearchDTO accountSearchDTO){
        log.info(accountSearchDTO.toString());
        if ((accountSearchDTO.getAccount()==null||accountSearchDTO.getAccount().isEmpty()) &&
                (accountSearchDTO.getIdNumber()==null||accountSearchDTO.getIdNumber().isEmpty()) &&
                (accountSearchDTO.getPhoneNumber()==null||accountSearchDTO.getPhoneNumber().isEmpty()))
            throw new ServiceException(400, "查询条件不能全部为空");
        return accountMapper.getAccountBalance(accountSearchDTO);
    }

    //转入帐户
    @Transactional
    public Boolean transferIn(AccountTransferDTO accountTransferDTO) {
        Account bankcard = accountMapper.selectOne(new QueryWrapper<Account>().eq("bankcard_number",accountTransferDTO.getCardNumber()));
        Assert.state(bankcard.getStatus().equals(1), 400, "转出账户已冻结");
        if (!BcryptUtil.match(accountTransferDTO.getCardPassword(), bankcard.getCardPassword()))
            throw new ServiceException(400, "银行卡密码错误");
        Account account = accountMapper.selectOne(new QueryWrapper<Account>().eq("user_id",bankcard.getUserId()).eq("type",0));
        Assert.state(account.getStatus().equals(1), 400, "转入账户已冻结");
        bankcard.setBalance(bankcard.getBalance().subtract(accountTransferDTO.getAmount()));
        account.setBalance(account.getBalance().add(accountTransferDTO.getAmount()));
        accountMapper.updateById(bankcard);
        accountMapper.updateById(account);
        return true;
    }

    //转出帐户
    public Boolean transferOut(AccountTransferDTO accountTransferDTO) {
        Account bankcard = accountMapper.selectOne(new QueryWrapper<Account>().eq("bankcard_number",accountTransferDTO.getCardNumber()));
        Assert.state(bankcard.getStatus().equals(1), 400, "转入账户已冻结");
        Account account = accountMapper.selectOne(new QueryWrapper<Account>().eq("user_id",bankcard.getUserId()).eq("type",0));
        Assert.state(account.getStatus().equals(1), 400, "转出账户已冻结");
        if (account.getBalance().compareTo(accountTransferDTO.getAmount()) < 0)
            throw new ServiceException(400, "余额不足");
        if (!BcryptUtil.match(accountTransferDTO.getCardPassword(), account.getCardPassword()))
            throw new ServiceException(400, "帐户密码错误");
        account.setBalance(account.getBalance().subtract(accountTransferDTO.getAmount()));
        bankcard.setBalance(bankcard.getBalance().add(accountTransferDTO.getAmount()));
        accountMapper.updateById(bankcard);
        accountMapper.updateById(account);
        return true;
    }

    public List<AccountSearchVO> selectAllAccount(AccountSearchDTO accountSearchDTO) {
        if ((accountSearchDTO.getAccount()==null||accountSearchDTO.getAccount().isEmpty()) &&
                (accountSearchDTO.getIdNumber()==null||accountSearchDTO.getIdNumber().isEmpty()) &&
                (accountSearchDTO.getPhoneNumber()==null||accountSearchDTO.getPhoneNumber().isEmpty()))
            throw new ServiceException(400, "查询条件不能全部为空");
        return accountMapper.selectAllAccount(accountSearchDTO);
    }

    public AccountSearchVO addAccount(Account account) {
        Assert.notNull(account.getBalance(), 400, "非法数据");
        account.setCardPassword(BcryptUtil.encode(account.getCardPassword()));
        account.setType(1);
        account.setStatus(0);
        account.setBalance(BigDecimal.ZERO);
        accountMapper.insert(account);
        return new AccountSearchVO(account.getAccountId()
                , account.getCardNumber(),account.getBelongBank(),account.getBalance());
    }

    public Boolean unbindAccount(Long accountId) {
        return accountMapper.update(null, new UpdateWrapper<Account>().set("is_deleted", true).eq("account_id", accountId)) > 0;
    }


}

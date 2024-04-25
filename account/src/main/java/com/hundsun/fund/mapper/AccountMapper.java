package com.hundsun.fund.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hundsun.fund.account.dto.AccountSaveDTO;
import com.hundsun.fund.account.dto.AccountSearchDTO;
import com.hundsun.fund.account.entity.Account;
import com.hundsun.fund.account.vo.AccountSearchVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author
 * @Date 2024/4/25 15:23
 * @Description
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    List<AccountSearchVO> selectAvailableAccount(AccountSearchDTO accountSearchDTO);

    List<AccountSearchVO> selectAllAccount(AccountSearchDTO accountSearchDTO);

    @Insert("Insert into account() values()")
    Boolean save(AccountSaveDTO accountSaveDTO);
}

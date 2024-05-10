package com.hundsun.fund.fund;

import com.hundsun.fund.fund.dto.NavDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.time.LocalDate;

@CloudService
public interface NavService {
    // 创建新的tnav记录
    @CloudFunction("createNav")
    int createNav(@RequestBody NavDTO navDTO);

    // 更新已有的tnav记录
    @CloudFunction("updateNav")
    Boolean updateNav(@PathVariable Long fundId, @PathVariable LocalDate date,@RequestBody NavDTO navDTO);

    // 查询所有的nav记录
    @CloudFunction("findAllNavs")
    List<NavDTO> findAllNavs();

    // 根据基金ID查询所有nav记录
    @CloudFunction("findNavById")
    List<NavDTO> findNavById(@PathVariable Long fundId);

    // 查找某天的所有基金nav记录
    @CloudFunction("findNavByDate")
    List<NavDTO> findNavByDate(@PathVariable LocalDate date);

    // 查找基金ID具体某天的nav记录
    @CloudFunction("findNavByDateAndID")
    NavDTO findNavByDateAndID(@PathVariable Long fundId, @PathVariable LocalDate date);
}

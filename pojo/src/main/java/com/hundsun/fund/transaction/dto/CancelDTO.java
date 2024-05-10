package com.hundsun.fund.transaction.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: Dding
 * @date: 2024/04/29
 **/
@Data
public class CancelDTO implements Serializable {

    // 撤单id
    Long cancellationId;

    // 用户id
    Long userId;

    // 请求id
    Long requestId;

    // 撤单时间
    LocalDateTime time;

}

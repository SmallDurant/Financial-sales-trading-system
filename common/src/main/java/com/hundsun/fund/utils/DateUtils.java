package com.hundsun.fund.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @Author
 * @Date 2022/12/9 10:14
 * @Description
 */
public class DateUtils {
    /**
     * 获取时间差,
     * @param endTime 结束页面
     * @param startTime 开始时间
     * @return
     */
    public static int getTimeDifference(Timestamp endTime, Timestamp startTime) {
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        long t1 = endTime.getTime();
        long t2 = startTime.getTime();
        int second=(int) (t1 - t2)/1000;
        return second;
    }
}

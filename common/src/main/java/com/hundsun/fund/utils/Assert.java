package com.hundsun.fund.utils;

import com.hundsun.fund.exception.ServiceException;

import java.util.Collection;
import java.util.Map;

/**
 * @Author
 * @Date 2024/4/11 13:25
 * @Description
 */
public class Assert {
    public static void isNull(Object object,int code, String message) {
        if (object == null) {
            throw new ServiceException(code, message);
        }
    }

    public static void state(boolean expression,int code, String message) {
        if (expression) {
            throw new ServiceException(code, message);
        }
    }

    public static void isEmpty(Collection collection, int code, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new ServiceException(code, message);
        }
    }

    public static void isEmpty(Map map, int code, String message) {
        if (map == null || map.isEmpty()) {
            throw new ServiceException(code, message);
        }
    }
}

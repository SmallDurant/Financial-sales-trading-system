package com.hunsun.fund.threadlocal;

import cn.hutool.core.convert.Convert;
import com.hundsun.fund.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author
 * @Date 2024/3/12 18:35
 * @Description
 */

public class ThreadLocalUtil {

    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(String key, Object value) {
        Map<String, Object> map = getLocalMap();
        map.put(key, value == null ? StringUtils.EMPTY : value);
    }

    public static String get(String key) {
        Map<String, Object> map = getLocalMap();
        return Convert.toStr(map.getOrDefault(key, StringUtils.EMPTY));
    }

    public static <T> T get(String key, Class<T> clazz) {
        Map<String, Object> map = getLocalMap();
        return StringUtils.cast(map.getOrDefault(key, null));
    }

    public static Map<String, Object> getLocalMap() {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>();
            THREAD_LOCAL.set(map);
        }
        return map;
    }

    public static void setLocalMap(Map<String, Object> threadLocalMap) {
        THREAD_LOCAL.set(threadLocalMap);
    }

    public static String getEmployeeId() {
        return get("employeeId");
    }

    public static void setEmployeeId(String employeeId) {
        set("employeeId", employeeId);
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}


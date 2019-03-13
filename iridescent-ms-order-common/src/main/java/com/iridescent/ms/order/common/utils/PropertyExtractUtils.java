package com.iridescent.ms.order.common.utils;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;


import java.lang.reflect.Method;
import java.util.*;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/13
 */
public class PropertyExtractUtils {

    public static <T> List<T> getByPropertyValue(List<? extends Object> list, String propertyName) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        List<T> retList = new ArrayList<T>(list.size());
        java.util.Set<T> set = new java.util.HashSet<T>(list.size());
        Class<?> clz = list.get(0).getClass();
        Method mth = getPropertyMethod(clz, propertyName);

        for (Object item : list) {
            Object value = null;
            try {
                value = mth.invoke(item);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (value == null) {
                continue;
            }
            set.add((T) value);
        }
        retList.addAll(set);
        return retList;
    }


    public static Method getPropertyMethod(Class clz, String propertyName) {
        Method mth = null;
        propertyName = upperFirstChar(propertyName);
        try {

            mth = clz.getMethod("get" + propertyName);
        } catch (Exception e) {
            try {
                mth = clz.getMethod("is" + propertyName);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            }
        }
        return mth;

    }

    public static String upperFirstChar(String source) {
        if (StringUtils.isEmpty(source)) {
            return "";
        }
        Character firstChar = source.charAt(0);
        if (Character.isLowerCase(firstChar)) {
            return Character.toUpperCase(firstChar) + source.substring(1);
        }
        return source;
    }

}

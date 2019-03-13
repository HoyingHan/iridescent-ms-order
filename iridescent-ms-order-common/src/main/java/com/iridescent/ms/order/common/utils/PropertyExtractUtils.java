package com.iridescent.ms.order.common.utils;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;

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
        } else {
            List<T> retList = new ArrayList(list.size());
            Set<T> set = new HashSet(list.size());
            Class<?> clz = list.get(0).getClass();
            Method mth = ReflectionUtils.getPropertyMethod(clz, propertyName);
            Iterator var6 = list.iterator();

            while(var6.hasNext()) {
                Object item = var6.next();
                Object value = null;

                try {
                    value = mth.invoke(item);
                } catch (Exception var10) {
                    throw new RuntimeException(var10);
                }

                if (value != null) {
                    set.add(value);
                }
            }

            retList.addAll(set);
            return retList;
        }
    }
}

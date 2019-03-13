package com.iridescent.ms.order.common.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/12
 */
@Slf4j
public class BeanConvertUtils {



    public static <FROM, TO> TO deepSafeConvertByFastJson(FROM dto, Class<FROM> fromClass, Class<TO> toClass) {
        try {
            if (dto == null) {
                return null;
            }
            String json = JSON.toJSONString(dto);
            return JSON.parseObject(json, toClass);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(),e);
        }
    }



    public static <FROM, TO> List<TO> deepSafeConvertByFastJson(List<FROM> dtos, Class<FROM> fromClass, Class<TO> toClass) {
        try {
            if (CollectionUtils.isEmpty(dtos)) {
                return new ArrayList<TO>(0);
            }
            String json = JSON.toJSONString(dtos);
            return JSON.parseArray(json, toClass);
        } catch (Exception e) {
            throw new RuntimeException("can not convert", e);
        }
    }



}

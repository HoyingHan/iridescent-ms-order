package com.iridescent.ms.order.api.fallback;

import com.iridescent.ms.order.api.CartBaseApi;
import com.iridescent.ms.order.common.vo.CartDetailVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/16
 */
@Component
@Slf4j
public class CartBaseApiFallbackFactory implements FallbackFactory<CartBaseApi> {


    @Override
    public CartBaseApi create(Throwable throwable) {
        return new CartBaseApi() {
            @Override
            public Boolean addToCart(List<String> productIds) {
                log.error("addToCart方法异常：异常信息：" + throwable);
                return null;
            }

            @Override
            public List<CartDetailVo> getCartDetailList(String cartId) {
                log.error("getCartDetailList方法异常：异常信息：" + throwable);
                return null;
            }
        };
    }
}

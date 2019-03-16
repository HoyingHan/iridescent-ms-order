package com.iridescent.ms.order.api.fallback;

import com.iridescent.ms.order.api.OrderBaseApi;
import com.iridescent.ms.order.common.vo.OrderDetailVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/16
 */
@Component
@Slf4j
public class OrderBaseApiFallbackFactory implements FallbackFactory<OrderBaseApi> {
    @Override
    public OrderBaseApi create(Throwable throwable) {
        return new OrderBaseApi() {
            @Override
            public Boolean payOrder(String cartId) {
                log.error("payOrder方法异常：异常信息：" + throwable);
                return null;
            }

            @Override
            public OrderDetailVo getOrderDetailByProductId(String productId) {
                log.error("getOrderDetailByProductId方法异常：异常信息：" + throwable);
                return null;
            }
        };
    }
}

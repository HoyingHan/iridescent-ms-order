package com.iridescentms.order.service.service;

import com.iridescent.ms.order.common.vo.OrderDetailVo;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderService {

    Boolean payOrder(@RequestParam(value = "cartId", required = false) String cartId);

    OrderDetailVo getOrderDetailByProductId(@RequestParam(value = "productId", required = false) String productId);

}

package com.iridescent.ms.order.api;

import com.iridescent.ms.order.common.vo.OrderDetailVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("order")
public interface OrderBaseApi {

    @PostMapping(value = "/rest/api/v1/order/pay")
    Boolean payOrder(@RequestParam(value = "cartId", required = false) String cartId);


    @GetMapping(value = "/rest/api/v1/order/getOrderDetailByProductId")
    OrderDetailVo getOrderDetailByProductId(@RequestParam(value = "productId", required = false) String productId);


}

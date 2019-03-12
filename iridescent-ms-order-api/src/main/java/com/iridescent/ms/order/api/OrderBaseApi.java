package com.iridescent.ms.order.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderBaseApi {

    @RequestMapping(value = "/rest/api/v1/order/pay", method = RequestMethod.POST)
    Boolean payOrder(@RequestParam(value = "cartId", required = false) String cartId);


}

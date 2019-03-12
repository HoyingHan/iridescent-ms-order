package com.iridescentms.order.service.service;

import org.springframework.web.bind.annotation.RequestParam;

public interface OrderService {

    Boolean payOrder(@RequestParam(value = "cartId", required = false) String cartId);

}

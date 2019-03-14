package com.iridescent.ms.order.api;

import com.iridescent.ms.order.common.vo.CartDetailVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/13
 */
@FeignClient("order")
public interface CartBaseApi {


    @PostMapping(value = "/rest/api/v1/order/cart/add")
    Boolean addToCart(@RequestParam(value = "productIds", required = false) List<String> productIds);


    @GetMapping(value = "/rest/api/v1/order/cart/list")
    List<CartDetailVo> getCartDetailList(@RequestParam(value = "cartId", required = false) String cartId);



}

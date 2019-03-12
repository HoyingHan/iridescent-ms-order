package com.iridescent.ms.order.api;

import com.iridescent.ms.order.common.vo.CartDetailVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/13
 */
public interface CartBaseApi {


    @RequestMapping(value = "/rest/api/v1/order/cart/add", method = RequestMethod.POST)
    Boolean addToCart(@RequestParam(value = "productIds", required = false) List<String> productIds);


    @RequestMapping(value = "/rest/api/v1/order/cart/list", method = RequestMethod.GET)
    List<CartDetailVo> getCartDetailList();



}

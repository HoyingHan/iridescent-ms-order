package com.iridescentms.order.service.service;

import com.iridescent.ms.order.common.vo.CartDetailVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/13
 */
public interface CartService {


    Boolean addToCart(@RequestParam(value = "productIds", required = false) List<String> productIds);

    List<CartDetailVo> getCartDetailList();

}

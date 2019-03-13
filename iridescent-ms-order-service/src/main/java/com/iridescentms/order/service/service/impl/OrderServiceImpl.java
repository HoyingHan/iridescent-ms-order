package com.iridescentms.order.service.service.impl;

import com.iridescent.ms.order.api.OrderBaseApi;
import com.iridescent.ms.order.common.vo.CartDetailVo;
import com.iridescentms.order.service.domain.CartDetail;
import com.iridescentms.order.service.service.CartService;
import com.iridescentms.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/13
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService, OrderBaseApi {

    @Resource
    private CartService cartService;


    @Override
    public Boolean payOrder(String cartId) {

        List<CartDetailVo> cartDetails = cartService.getCartDetailList();


        return null;
    }
}

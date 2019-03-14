package com.iridescentms.order.service.service.impl;

import com.iridescent.ms.order.api.OrderBaseApi;
import com.iridescent.ms.order.common.utils.PropertyExtractUtils;
import com.iridescent.ms.order.common.vo.CartDetailVo;
import com.iridescent.ms.order.common.vo.OrderDetailVo;
import com.iridescentms.order.service.dao.OrderDetailDao;
import com.iridescentms.order.service.domain.CartDetail;
import com.iridescentms.order.service.service.CartService;
import com.iridescentms.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/13
 */
@RestController
public class OrderServiceImpl implements OrderService, OrderBaseApi {

    @Resource
    private CartService cartService;

    @Resource
    private OrderDetailDao orderDetailDao;


    @Override
    @PostMapping(value = "/rest/api/v1/order/pay")
    public Boolean payOrder(@RequestParam(value = "cartId", required = false) String cartId) {

        List<CartDetailVo> cartDetails = cartService.getCartDetailList(cartId);
        List<String> productIds = PropertyExtractUtils.getByPropertyValue(cartDetails, "productId");
        productIds.forEach(id -> {

        });


        return null;
    }

    @Override
    @GetMapping(value = "/rest/api/v1/order/getOrderDetailByProductId")
    public OrderDetailVo getOrderDetailByProductId(@RequestParam(value = "productId", required = false) String productId){
        // orderDetailDao.findOne(productId);
        return null;
    }
}

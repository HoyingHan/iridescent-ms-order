package com.iridescent.ms.order.service.service.impl;

import com.iridescent.ms.order.api.OrderBaseApi;
import com.iridescent.ms.order.common.utils.PropertyExtractUtils;
import com.iridescent.ms.order.common.vo.CartDetailVo;
import com.iridescent.ms.order.common.vo.OrderDetailVo;
import com.iridescent.ms.order.service.dao.OrderDetailDao;
import com.iridescent.ms.order.service.service.CartService;
import com.iridescent.ms.order.service.service.OrderService;
import org.springframework.web.bind.annotation.*;

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

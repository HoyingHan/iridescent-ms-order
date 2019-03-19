package com.iridescent.ms.order.service.service.impl;

import com.iridescent.ms.order.api.OrderBaseApi;
import com.iridescent.ms.order.common.utils.BeanConvertUtils;
import com.iridescent.ms.order.common.utils.PropertyExtractUtils;
import com.iridescent.ms.order.common.vo.CartDetailVo;
import com.iridescent.ms.order.common.vo.OrderDetailVo;
import com.iridescent.ms.order.service.dao.OrderDetailDao;
import com.iridescent.ms.order.service.domain.OrderDetail;
import com.iridescent.ms.order.service.service.CartService;
import com.iridescent.ms.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
            OrderDetailVo orderDetailVo = getOrderDetailByProductId(id);
            if (orderDetailVo == null) {
                return;
            }
            orderDetailDao.save(BeanConvertUtils.deepSafeConvertByFastJson(orderDetailVo, OrderDetailVo.class, OrderDetail.class));
        });
        return true;
    }

    @Override
    @GetMapping(value = "/rest/api/v1/order/getOrderDetailByProductId")
    public OrderDetailVo getOrderDetailByProductId(@RequestParam(value = "productId", required = false) String productId){
        List<String> productIds = new ArrayList<>();
        productIds.add(productId);
        List<OrderDetail> orderDetails = orderDetailDao.findAllById(productIds);
        if (orderDetails == null || orderDetails.size() == 0) {
            return null;
        }
        return BeanConvertUtils.deepSafeConvertByFastJson(orderDetails.get(0), OrderDetail.class, OrderDetailVo.class);
    }
}

package com.iridescentms.order.service.service.impl;

import com.google.common.collect.Lists;
import com.iridescent.ms.order.api.CartBaseApi;
import com.iridescent.ms.order.common.utils.BeanConvertUtils;
import com.iridescent.ms.order.common.vo.CartDetailVo;
import com.iridescent.ms.product.api.ProductInfoApi;
import com.iridescent.ms.product.common.vo.ProductInfoVo;
import com.iridescentms.order.service.dao.CartDetailDao;
import com.iridescentms.order.service.domain.CartDetail;
import com.iridescentms.order.service.service.CartService;
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
public class CartServiceImpl implements CartService, CartBaseApi {


    @Resource
    private CartDetailDao cartDetailDao;

    @Resource
    private ProductInfoApi productInfoApi;


    @Override
    @PostMapping(value = "/rest/api/v1/order/cart/add")
    public Boolean addToCart(@RequestParam(value = "productIds", required = false) List<String> productIds) {

        List<ProductInfoVo> productInfoVoList = productInfoApi.getProductListByIds(productIds);
        List<CartDetailVo> cartDetailList = Lists.newArrayList();

        productInfoVoList.forEach( info ->{
            CartDetailVo cartDetailVo = BeanConvertUtils.deepSafeConvertByFastJson(info, ProductInfoVo.class, CartDetailVo.class);
            cartDetailList.add(cartDetailVo);
        });

        cartDetailDao.saveAll(BeanConvertUtils.deepSafeConvertByFastJson(cartDetailList, CartDetailVo.class, CartDetail.class));
        return true;
    }


    @Override
    @GetMapping(value = "/rest/api/v1/order/cart/list")
    public List<CartDetailVo> getCartDetailList(@RequestParam(value = "cartId", required = false) String cartId) {
        return BeanConvertUtils.deepSafeConvertByFastJson(cartDetailDao.findAll(), CartDetail.class, CartDetailVo.class);
    }

}

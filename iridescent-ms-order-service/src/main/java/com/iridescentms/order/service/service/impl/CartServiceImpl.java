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
@Service("CartService")
public class CartServiceImpl implements CartService, CartBaseApi {


    @Resource
    private CartDetailDao cartDetailDao;

    @Autowired
    private ProductInfoApi productInfoApi;


    @Override
    public Boolean addToCart(List<String> productIds) {

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
    public List<CartDetailVo> getCartDetailList() {
        return BeanConvertUtils.deepSafeConvertByFastJson(cartDetailDao.findAll(), CartDetail.class, CartDetailVo.class);
    }

}

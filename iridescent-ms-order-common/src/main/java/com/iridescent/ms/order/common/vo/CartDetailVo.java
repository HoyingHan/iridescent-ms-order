package com.iridescent.ms.order.common.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/13
 */


@Data
public class CartDetailVo {

    private String detailId;

    /**
     * 购物车Id
     */
    private String cartId;

    /**
     * 产品Id
     */
    private String productId;

    /**
     * 名字
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 购买数量
     */
    private Integer productQuantity;


}

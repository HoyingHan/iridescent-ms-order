package com.iridescent.ms.order.common.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Description:
 *
 * @author hanhongying@corp.netease.com
 * @version 2019/3/13
 */
@Data
public class OrderDetailVo {


    private String detailId;

    /**
     * 订单Id
     */
    private String orderId;

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

    /**
     * 图片
     */
    private String productImage;


}

package com.iridescentms.order.service.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/13
 */
@Entity
@Data
@DynamicUpdate
public class CartDetail {

    @Id
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

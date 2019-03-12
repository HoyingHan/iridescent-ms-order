package com.iridescentms.order.service.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Description: 订单信息
 *
 * @author 陌北有棵树
 * @version 2019/3/13
 */
@DynamicUpdate
@Data
@Entity
public class OrderInfo {

    /**
     * 订单ID
     */
    @Id
    private String orderId;

    /**
     * 购物车Id
     */
    private String cartId;

    /**
     * 订单创建时间
     */
    private Date orderCreateTime;

}

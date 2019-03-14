package com.iridescent.ms.order.service.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Description: 购物车
 *
 * @author 陌北有棵树
 * @version 2019/3/13
 */
@DynamicUpdate
@Data
@Entity
public class CartInfo {

    @Id
    private String cartId;


}

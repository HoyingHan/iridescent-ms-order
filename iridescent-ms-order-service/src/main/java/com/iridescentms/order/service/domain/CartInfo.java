package com.iridescentms.order.service.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Description:
 *
 * @author 购物车
 * @version 2019/3/13
 */
@DynamicUpdate
@Data
@Entity
public class CartInfo {

    @Id
    private String cartId;


}

package com.iridescentms.order.service.dao;

import com.iridescentms.order.service.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {


}

package com.iridescentms.order.service.dao;

import com.iridescentms.order.service.domain.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInfoDao extends JpaRepository<OrderInfo, String> {


}

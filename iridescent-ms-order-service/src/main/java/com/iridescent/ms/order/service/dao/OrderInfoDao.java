package com.iridescent.ms.order.service.dao;

import com.iridescent.ms.order.service.domain.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInfoDao extends JpaRepository<OrderInfo, String> {


}

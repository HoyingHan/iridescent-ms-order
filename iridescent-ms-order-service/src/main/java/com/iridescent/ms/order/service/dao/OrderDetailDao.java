package com.iridescent.ms.order.service.dao;

import com.iridescent.ms.order.service.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {

}

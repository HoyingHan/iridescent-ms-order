package com.iridescentms.order.service.dao;

import com.iridescentms.order.service.domain.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailDao extends JpaRepository<CartDetail, String> {

}

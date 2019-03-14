package com.iridescent.ms.order.service.dao;

import com.iridescent.ms.order.service.domain.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailDao extends JpaRepository<CartDetail, String> {

}

package com.iridescent.ms.order.service.dao;

import com.iridescent.ms.order.service.domain.CartInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartInfoDao extends JpaRepository<CartInfo, String> {

}

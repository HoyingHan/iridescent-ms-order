package com.iridescentms.order.service.dao;

import com.iridescentms.order.service.domain.CartInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartInfoDao extends JpaRepository<CartInfo, String> {

}

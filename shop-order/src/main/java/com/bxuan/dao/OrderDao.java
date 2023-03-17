package com.bxuan.dao;

import com.bxuan.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: BXuan
 * @Date: 2023/03/17/ 21:54
 * @description
 */

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
}

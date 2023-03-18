package com.bxuan.service.impl;

import com.bxuan.dao.OrderDao;
import com.bxuan.domain.Order;
import com.bxuan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: BXuan
 * @Date: 2023/03/17/ 21:55
 * @description
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addOrder(Order order) {
        orderDao.save(order);
    }
}

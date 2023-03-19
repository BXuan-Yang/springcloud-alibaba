package com.bxuan.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.bxuan.dao.ProductDao;
import com.bxuan.domain.Product;
import com.bxuan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: BXuan
 * @Date: 2023/03/17/ 21:45
 * @description
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findById(Integer pid) {
        return productDao.findById(pid).get();
    }

    @Override
    public void addProduct(Product product) {
        productDao.save(product);
    }

    @Override
    @SentinelResource("message")
    public String message() {
        return "message";
    }
}

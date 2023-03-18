package com.bxuan.service;

import com.bxuan.domain.Product;

/**
 * @Author: BXuan
 * @Date: 2023/03/17/ 21:44
 * @description
 */

public interface ProductService {

    Product findById(Integer pid);

    void addProduct(Product product);
}

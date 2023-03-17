package com.bxuan.dao;

import com.bxuan.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: BXuan
 * @Date: 2023/03/17/ 21:43
 * @description
 */

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
}

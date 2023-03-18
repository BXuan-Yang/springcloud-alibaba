package com.bxuan.service;

import com.bxuan.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: BXuan
 * @Date: 2023/03/18/ 15:19
 * @description
 */

@FeignClient(value = "service-product")
public interface ProductService {

    @GetMapping("/product/find/{pid}")
    Product findProductById(@PathVariable("pid") Integer pid);

}

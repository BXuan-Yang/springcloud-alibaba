package com.bxuan.controller;

import com.alibaba.fastjson.JSON;
import com.bxuan.domain.Product;
import com.bxuan.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: BXuan
 * @Date: 2023/03/17/ 21:44
 * @description
 */

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/find/{pid}")
    public Product findProduct(@PathVariable("pid") Integer pid){
        log.info("进行{}号商品查询", pid);
        Product product = productService.findById(pid);
        log.info("商品信息查询成功：{}", JSON.toJSONString(product));
        return product;
    }

    @PostMapping("/product/add")
    public String addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "添加成功";
    }

}

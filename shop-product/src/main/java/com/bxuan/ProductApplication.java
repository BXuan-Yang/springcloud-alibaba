package com.bxuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: BXuan
 * @Date: 2023/03/17/ 21:42
 * @description
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}

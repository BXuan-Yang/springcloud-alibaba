package com.bxuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: BXuan
 * @Date: 2023/03/19/ 1:08
 * @description
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayApplication.class, args);
    }
}

package com.bxuan.controller;

import com.alibaba.fastjson.JSON;
import com.bxuan.domain.Order;
import com.bxuan.domain.Product;
import com.bxuan.service.OrderService;
import com.bxuan.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: BXuan
 * @Date: 2023/03/17/ 21:55
 * @description
 */

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ProductService productService;

    @PostMapping("/order/add/{pid}")
    public Order addOrder(@PathVariable("pid") Integer pid){
        log.info("对{}号商品进行下单操作", pid);
//        List<ServiceInstance> list = discoveryClient.getInstances("service-product");
//        // 进行随机负载均衡
//        int index = new Random().nextInt(list.size());
//        ServiceInstance serviceInstance = list.get(0);
//        Product product = restTemplate.getForObject("http://" + serviceInstance.getHost()
//                                                    + ":" + serviceInstance.getPort()
//                                                    + "/product/find/"
//                                                    + pid, Product.class);
        Product product = restTemplate.getForObject("http://service-product/product/find/" + pid, Product.class);
        log.info("商品信息为：{}", JSON.toJSONString(product));
        Order order = new Order();
        order.setUid(1);
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.addOrder(order);
        log.info("{}号商品下单成功", pid);
        return order;
    }

    @GetMapping("/order/findProduct/{pid}")
    public Order orderFindPoduct(@PathVariable("pid") Integer pid){
        log.info("对{}号商品进行查询操作", pid);
//        List<ServiceInstance> list = discoveryClient.getInstances("service-product");
//        // 进行随机负载均衡
//        int index = new Random().nextInt(list.size());
//        ServiceInstance serviceInstance = list.get(0);
//        Product product = restTemplate.getForObject("http://" + serviceInstance.getHost()
//                                                    + ":" + serviceInstance.getPort()
//                                                    + "/product/find/"
//                                                    + pid, Product.class);
        Product product = productService.findProductById(pid);
        log.info("商品信息为：{}", JSON.toJSONString(product));
        Order order = new Order();
        order.setUid(1);
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
//        orderService.addOrder(order);
        log.info("{}号商品查询成功", pid);
        return order;
    }
}

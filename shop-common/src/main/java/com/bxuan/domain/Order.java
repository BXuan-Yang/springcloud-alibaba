package com.bxuan.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: BXuan
 * @Date: 2023/03/17/ 21:24
 * @description
 */

@Data
@Entity(name = "shop_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private Integer uid;
    private Integer pid;
    private String pname;
    private String pprice;
    private Integer number;

}

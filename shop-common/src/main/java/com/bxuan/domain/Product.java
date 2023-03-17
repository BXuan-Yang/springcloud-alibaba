package com.bxuan.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: BXuan
 * @Date: 2023/03/17/ 21:31
 * @description
 */

@Data
@Entity(name = "shop_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private String pname;
    private String pprice;
    private Integer stock;

}

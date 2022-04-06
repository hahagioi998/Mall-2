/**
  * Copyright 2021 bejson.com 
  */
package com.mall.product.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yaoxinjia
 */
@Data
public class Bounds {

    private BigDecimal buyBounds;
    private BigDecimal growBounds;

}
package com.wangli.service;

import com.wangli.pojo.Cart;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.service
 * @ClassName: OrderService
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/8 23:28
 * @Version: 1.0
 */
public interface OrderService {

    public String createOrder(Cart cart, Integer userId);

}

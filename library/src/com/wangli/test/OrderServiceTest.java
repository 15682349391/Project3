package com.wangli.test;

import com.wangli.pojo.Cart;
import com.wangli.pojo.CartItem;
import com.wangli.service.OrderService;
import com.wangli.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.test
 * @ClassName: OrderServiceTest
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/9 0:20
 * @Version: 1.0
 */
public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();
    @Test
    public void createOrder() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));


        System.out.println(orderService.createOrder(cart, 1));
    }
}
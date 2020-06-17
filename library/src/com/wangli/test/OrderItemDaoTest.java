package com.wangli.test;

import com.wangli.dao.OrderDao;
import com.wangli.dao.OrderItemDao;
import com.wangli.dao.impl.OrderItemDaoImpl;
import com.wangli.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.test
 * @ClassName: OrderItemDaoTest
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/8 23:16
 * @Version: 1.0
 */
public class OrderItemDaoTest {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {

        orderItemDao.saveOrderItem(new OrderItem(null, "java从入门到精通", 1, new BigDecimal(100), new BigDecimal(100), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "数据结构", 1, new BigDecimal(212), new BigDecimal(212), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "Android第一人", 2, new BigDecimal(432), new BigDecimal(432), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "算法分析与设计", 6, new BigDecimal(21), new BigDecimal(21), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "软件工程", 10, new BigDecimal(5), new BigDecimal(5), "1234567890"));

    }
}
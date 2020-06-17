package com.wangli.test;

import com.wangli.dao.OrderDao;
import com.wangli.dao.impl.BaseDao;
import com.wangli.dao.impl.OderDaoImpl;
import com.wangli.dao.impl.OrderItemDaoImpl;
import com.wangli.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.test
 * @ClassName: OrderDaoTest
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/8 23:07
 * @Version: 1.0
 */
public class OrderDaoTest {
    OrderDao orderDao = new OderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1234567890",new Date(),new BigDecimal(999),0,1));
    }
}
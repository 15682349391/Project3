package com.wangli.dao;

import com.wangli.pojo.Order;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.dao
 * @ClassName: OrderDao
 * @Author: 38272
 * @Description: 订单DAO
 * @Date: 2020/5/8 22:39
 * @Version: 1.0
 */
public interface OrderDao {

    public int saveOrder(Order order);


}

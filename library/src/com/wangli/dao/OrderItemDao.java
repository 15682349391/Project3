package com.wangli.dao;

import com.wangli.pojo.OrderItem;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.dao
 * @ClassName: OrderItemDao
 * @Author: 38272
 * @Description: 订单项Dao
 * @Date: 2020/5/8 22:46
 * @Version: 1.0
 */
public interface OrderItemDao {

    public int saveOrderItem(OrderItem orderItem);

}

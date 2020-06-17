package com.wangli.dao.impl;

import com.wangli.dao.OrderItemDao;
import com.wangli.pojo.OrderItem;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.dao.impl
 * @ClassName: OrderItemDaoImpl
 * @Author: 38272
 * @Description: OrderItemDao的实现
 * @Date: 2020/5/8 23:02
 * @Version: 1.0
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {

        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";

        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());

    }
}

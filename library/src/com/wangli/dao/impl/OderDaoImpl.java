package com.wangli.dao.impl;

import com.wangli.dao.OrderDao;
import com.wangli.pojo.Order;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.dao.impl
 * @ClassName: OderDaoImpl
 * @Author: 38272
 * @Description: OrderDao的实现
 * @Date: 2020/5/8 22:41
 * @Version: 1.0
 */
public class OderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {

        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());

    }
}

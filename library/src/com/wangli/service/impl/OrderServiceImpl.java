package com.wangli.service.impl;

import com.wangli.dao.BookDao;
import com.wangli.dao.OrderDao;
import com.wangli.dao.OrderItemDao;
import com.wangli.dao.impl.BookDaoImpl;
import com.wangli.dao.impl.OderDaoImpl;
import com.wangli.dao.impl.OrderItemDaoImpl;
import com.wangli.pojo.*;
import com.wangli.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.service.impl
 * @ClassName: OrderServiceImpl
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/8 23:30
 * @Version: 1.0
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

        String orderId = String.valueOf(System.currentTimeMillis()+userId);

        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);

        orderDao.saveOrder(order);

        //制造异常
        int i = 12/0;


        for (Map.Entry<Integer, CartItem> items : cart.getItems().entrySet()) {
            //遍历到每个map对象，获取每个购物车汇总的商品项
            CartItem item = items.getValue();
            //转换成每一个订单项
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(),item.getPrice(), item.getTotalPrice(),orderId);
            //保存到数据库
            orderItemDao.saveOrderItem(orderItem);
            //更新库存和销量
            Book book = bookDao.queryBookById(item.getId());
            book.setSales(book.getSales() + item.getCount());
            book.setStock(book.getStock() - item.getCount());
            bookDao.updateBook(book);
        }


        //清空购物车
        cart.clear();
        return orderId;
    }
}

package com.wangli.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.pojo
 * @ClassName: Cart
 * @Author: 38272
 * @Description: 购物车
 * @Date: 2020/5/8 10:08
 * @Version: 1.0
 */
public class Cart {
    //private Integer totalCount;
    //private BigDecimal totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();


    //增加商品
    public void addItem(CartItem cartItem){
        //查找map中是否已经存在该id的cartItem
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            //数量累加
            item.setCount(item.getCount()+1);
            //金额累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));

        }

    }

     //删除商品
    public void deleteItem(Integer id){
        items.remove(id);
    }

    //清空购物有车
    public void clear(){
        items.clear();
    }


    public void updateCount(Integer id, Integer Count){
        //查找map中是否已经存在该id的cartItem
        CartItem item = items.get(id);
        if (item != null) {
            items.get(id).setCount(Count);
            items.get(id).setTotalPrice(item.getPrice().multiply(new BigDecimal(Count)));
        }

    }



    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }

        /*for (CartItem item : items.values() ) {
            totalCount += item.getCount();
        }*/

        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            //totalPrice += entry.getValue().getTotalPrice(); 行不通
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}

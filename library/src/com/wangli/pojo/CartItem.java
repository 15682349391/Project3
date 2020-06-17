package com.wangli.pojo;

import java.math.BigDecimal;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.pojo
 * @ClassName: CartItem
 * @Author: 38272
 * @Description: 购物车对象
 * @Date: 2020/5/8 10:04
 * @Version: 1.0
 */
public class CartItem {
    private Integer id;
    private String name;
    private Integer count;
    private String publish;
    private String anthuer;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", publish='" + publish + '\'' +
                ", anthuer='" + anthuer + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getAnthuer() {
        return anthuer;
    }

    public void setAnthuer(String anthuer) {
        this.anthuer = anthuer;
    }

    public CartItem(Integer id, String name, Integer count, String publish, String anthuer) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.publish = publish;
        this.anthuer = anthuer;
    }

    public CartItem() {
    }
}

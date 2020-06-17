package com.wangli.pojo;

import java.math.BigDecimal;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.pojo
 * @ClassName: Book
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/3 20:14
 * @Version: 1.0
 */
public class Book {

    private Integer id;
    private String name;
    private String publish;
    private String author;
    private String num;
    private Integer stock;
    private String imgPath = "static/img/default.jpg";

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publish='" + publish + '\'' +
                ", author='" + author + '\'' +
                ", num='" + num + '\'' +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
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

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Book(Integer id, String name, String publish, String author, String num, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.publish = publish;
        this.author = author;
        this.num = num;
        this.stock = stock;
        this.imgPath = imgPath;
    }

    public Book() {
    }
}

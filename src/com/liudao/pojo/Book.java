package com.liudao.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/3 - 21:55
 */
public class Book implements Serializable {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer sales;//销量
    private String author;
    private Integer stock;//库存
    private String imaPath="static/img/default.jpg";

    public Book() {
    }

    public Book(Integer id, String name, BigDecimal price, Integer sales, String author, Integer stock, String imaPath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
        this.author = author;
        this.stock = stock;
        if(imaPath != null || !"".equals(imaPath)){
            this.imaPath = imaPath;
        }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImaPath() {
        return imaPath;
    }

    public void setImaPath(String imaPath) {
        if(imaPath != null || !"".equals(imaPath)){
            this.imaPath = imaPath;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", author='" + author + '\'' +
                ", stock=" + stock +
                ", imaPath='" + imaPath + '\'' +
                '}';
    }
}

package com.liudao.service;


import com.liudao.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}

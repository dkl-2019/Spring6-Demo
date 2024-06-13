package com.kunling.spring6.tx.dao;

public interface BookDao {
    Integer getBookPrice(Integer bookId);   // 根据图书id先查询图书价格

    void updateStock(Integer bookId);   // 更新图书表里面的库存量 -1

    void updateUserBalance(Integer userId, Integer price);  // 更新用户表里面的用户余额 -图书价格
}

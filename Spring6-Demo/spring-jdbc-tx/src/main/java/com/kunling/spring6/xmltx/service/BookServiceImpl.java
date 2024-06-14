package com.kunling.spring6.xmltx.service;

import com.kunling.spring6.xmltx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 根据图书id先查询图书价格
        Integer price = bookDao.getBookPrice(bookId);
        // 更新图书表里面的库存量 -1
        bookDao.updateStock(bookId);
        // 更新用户表里面的用户余额 -图书价格
        bookDao.updateUserBalance(userId, price);

    }

}

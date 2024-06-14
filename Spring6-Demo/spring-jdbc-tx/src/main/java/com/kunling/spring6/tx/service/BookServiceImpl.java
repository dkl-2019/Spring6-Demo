package com.kunling.spring6.tx.service;

import com.kunling.spring6.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

//@Transactional(isolation = Isolation.DEFAULT)//使用数据库默认的隔离级别
//@Transactional(isolation = Isolation.READ_UNCOMMITTED)//读未提交
//@Transactional(isolation = Isolation.READ_COMMITTED)//读已提交
//@Transactional(isolation = Isolation.REPEATABLE_READ)//可重复读
//@Transactional(isolation = Isolation.SERIALIZABLE)//串行化
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;


    @Override
    public void buyBook(Integer bookId, Integer userId) {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        // 根据图书id先查询图书价格
        Integer price = bookDao.getBookPrice(bookId);
        // 更新图书表里面的库存量 -1
        bookDao.updateStock(bookId);
        // 更新用户表里面的用户余额 -图书价格
        bookDao.updateUserBalance(userId, price);

//        System.out.println(1/0);
    }

}

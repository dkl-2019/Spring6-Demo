package com.kunling.spring6.tx.controller;

import com.kunling.spring6.tx.service.BookService;
import com.kunling.spring6.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    // 买书的方法：买书的id和用户id
    public void buyBook(Integer bookId,Integer userId) {
        // 调用service方法
        bookService.buyBook(bookId, userId);

    }

    @Autowired
    private CheckoutService checkoutService;

    public void checkout(Integer[] bookIds, Integer userId) {
        // 调用service方法
        checkoutService.checkout(bookIds, userId);

    }

}

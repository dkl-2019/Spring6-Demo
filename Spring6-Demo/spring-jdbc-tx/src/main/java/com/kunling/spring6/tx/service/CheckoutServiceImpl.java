package com.kunling.spring6.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CheckoutServiceImpl implements CheckoutService{

    // 注入BookService
    @Autowired
    private BookService bookService;

    @Transactional
    @Override
    public void checkout(Integer[] bookIds, Integer id) {
        for (Integer bookId :
                bookIds) {
            bookService.buyBook(bookId, id);
        }
    }
}

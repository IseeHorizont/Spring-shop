package com.example.springshop.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @After("@annotation(logCreateCart)")
    protected Object logAddProduct(LogCreateCart logCreateCart) {
        System.out.println("Create a new cart");
        return null;
    }

    @After("@annotation(logAddProduct)")
    protected Object logDeleteProduct(LogAddProduct logAddProduct) {
        System.out.println("Added product in cart");
        return null;
    }


    @After("@annotation(logDeleteProduct)")
    protected Object logDeleteProduct(LogDeleteProduct logDeleteProduct) {
        System.out.println("Deleted product from cart");
        return null;
    }
}

package com.example.springshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShopApplication.class, args);
    }

    // USER - пользователь
    // ROLE - Роль - Менеджер (Контролирование количества товаров, Просмотр покупателей),
    // Покупатель(заказ товара), если успеем добавим Администратора
    // PRODUCT - Товар(если успеем, то добавление файлов(например фото товара))
    // REVIEWS - Отзывы
    // Cart - корзина
    // Двухфакторная авторизация
}

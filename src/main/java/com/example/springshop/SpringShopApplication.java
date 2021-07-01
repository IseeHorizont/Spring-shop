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

    // hw5
    // Сделать возможность отправить письмо через вашу личную гугл почту.
    // В качестве подтверждения выполнения работы принимается файл credentials.json
    // или письмо на мою почту xzi123@mail.ru

}

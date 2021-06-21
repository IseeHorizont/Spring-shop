package com.example.springshop.service;

import com.example.springshop.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartService {
    private List<Product> productList;

    public CartService() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addProduct(Set<Product> products) {
        productList.addAll(products.stream().map(
                product -> {
                    var newProduct = new Product();
                    newProduct.setCount(1);
                    newProduct.setName(product.getName());
                    newProduct.setId(product.getId());
                    return newProduct;
                }
        ).collect(Collectors.toList()));
    }

    public void deleteProduct(Product product) {
        productList.removeIf(p -> p.getId().equals(product.getId()));
    }

    public void increaseProductCount(Product product) {
        for(Product innerProduct: productList) {
            if (product.getId().equals(innerProduct.getId())) {
                innerProduct.incrementCount();
                return;
            }
        }
    }

    public void decreaseProductCount(Product product) {
        for(Product innerProduct: productList) {
            if (product.getId().equals(innerProduct.getId())) {
                innerProduct.decrementCount();
                return;
            }
        }
    }

    public List<Product> getProducts() {
        return productList;
    }
}

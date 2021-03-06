package com.example.springshop.frontend;

import com.example.springshop.model.Product;
import com.example.springshop.repository.ProductRepository;
import com.example.springshop.service.CartService;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;


@Route("main")
public class MainView extends VerticalLayout {
    private final Grid<Product> grid = new Grid<>(Product.class);

    private final ProductRepository productRepository;
    private final CartService cartService;

    public MainView(ProductRepository productRepository, CartService cartService) {
        this.productRepository = productRepository;
        this.cartService = cartService;

        initPage();
    }

    private void initPage() {
        
        initProductGrid();
        grid.setColumns("name", "count");
        add(grid, initCartButton());
    }

    private HorizontalLayout initCartButton() {

        var addToCartButton = new Button("Add to cart", item -> {
            cartService.addProduct(grid.getSelectedItems());
            Notification.show("Product added in cart");
        });

        var toCartButton = new Button("Go to cart", item -> {
            UI.getCurrent().navigate("cart");
        });

        return new HorizontalLayout(addToCartButton);
    }

    private void initProductGrid() {
        var products = productRepository.findAll();

        grid.setItems(productRepository.findAll());
        grid.setSizeUndefined();
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        ListDataProvider<Product> dataProvider = DataProvider.ofCollection(products);
        grid.setDataProvider(dataProvider);

        grid.addColumn(new ComponentRenderer<>(item -> {
            var plusButton = new Button("+", i -> {
                item.incrementCount();
                productRepository.save(item);
                grid.getDataProvider().refreshAll();
            });

            var minusButton = new Button("-", i -> {
                item.decrementCount();
                productRepository.save(item);
                grid.getDataProvider().refreshAll();
            });

            return new HorizontalLayout(plusButton, minusButton);
        }));
    }
}

package com.example.order.controller;

import com.example.order.contract.Order;
import com.example.order.contract.Product;
import com.example.order.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    ProductFeignClient feignClient;

    @Autowired
    public OrderController(ProductFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @GetMapping("/orders")
    public Order getOrders() {
        List<Product> products = feignClient.getAllProducts();
        return  new Order(1, "Online", products);
    }

    @GetMapping("/order/{id}")
    public Order getProducts(@PathVariable int id) {
        List<Product> products = new ArrayList<Product>();
        products.add(feignClient.getProduct(id));
        return new Order(1, "Offline", products);
    }
}

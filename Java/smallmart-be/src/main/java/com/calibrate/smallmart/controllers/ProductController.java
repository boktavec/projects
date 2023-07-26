package com.calibrate.smallmart.controllers;

import com.calibrate.smallmart.managers.ProductManager;
import com.calibrate.smallmart.models.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

//Product related routes
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

    private ArrayList<addToCart> cart = new ArrayList<>();

    @GetMapping("/products")
    public Collection getAllProducts() {

        Collection productsList = ProductManager.productManager.values();

        return productsList;
    }
    @GetMapping("/products/{id}")
    public ArrayList getProduct(@PathVariable String id){
        id = id.toLowerCase();

        Product product = ProductManager.productManager.get(id);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);

        return productList;
    }

    @GetMapping("/cart")
    public ArrayList getCart() {

        return cart;
    }

    @PostMapping("/sell")
    public void sellProduct(@RequestBody productToSell product){
        Product newProduct = new Product(product.getName(), product.getPrice(), product.getDescription());

        ProductManager.productManager.put(newProduct.getProductName(), newProduct);


    }

    @PostMapping("/buy")
    public void addToCart(@RequestBody addToCart info) {
        cart.add(info);

    }
}

@Getter @AllArgsConstructor @NoArgsConstructor
class productToSell {
    private String name, description;
    private double price;
}

@Getter @AllArgsConstructor @NoArgsConstructor
class addToCart {
    private String productName, productSize;
    private double productPrice;

    @Override
    public String toString() {
        return "{" +
                "productName='" + productName + '\'' +
                ", productSize='" + productSize + '\'' +
                ", price=" + productPrice +
                '}';
    }
}
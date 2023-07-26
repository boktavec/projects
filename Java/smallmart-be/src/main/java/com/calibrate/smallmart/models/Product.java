package com.calibrate.smallmart.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter @Setter @NoArgsConstructor
public class Product {
    private static int increasedId = 0;
    private int productId;
    private String productName;
    private double productPrice;
    private ArrayList<String> productSizes;
    private String productDescription;

    public Product(String productName, double productPrice, String productDescription) {
        this.productId = generateId();
        this.productName = productName.toLowerCase();
        this.productPrice = productPrice;
        this.productSizes = new ArrayList<>();
        this.productDescription = productDescription;

        //default sizes
        this.productSizes.add("XXXS");
        this.productSizes.add("XXS");
        this.productSizes.add("XS");
        this.productSizes.add("S");

    }

    private int generateId() {
        increasedId++;
        return increasedId;

    }


    @Override
    public String toString() {
        return "{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productSizes=" + productSizes +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}

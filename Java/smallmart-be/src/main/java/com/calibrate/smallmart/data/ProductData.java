package com.calibrate.smallmart.data;

import com.calibrate.smallmart.managers.ProductManager;
import com.calibrate.smallmart.models.Product;

public class ProductData {
    public static void productData() {


        //T-Shirt
        Product shirtProduct = new Product("T-Shirt", 12.00, "This is a t-shirt for small people.");
        String shirtId = shirtProduct.getProductName();
        ProductManager.productManager.put(shirtId, shirtProduct);


        //Jeans
        Product jeanProduct = new Product("Jeans", 21.00, "This is a pair of jeans for small people.");
        String jeanId = jeanProduct.getProductName();

        ProductManager.productManager.put(jeanId, jeanProduct);


        //Shoes
        Product shoeProduct = new Product("Shoes", 33.00, "This is a pair of shoes for small people.");
        String shoeId = shoeProduct.getProductName();

        ProductManager.productManager.put(shoeId, shoeProduct);


    }

}

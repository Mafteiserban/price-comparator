package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {

    private String productId;
    private String name;
    private String category;
    private String brand;
    private double quantity;
    private String unit;
    private double price;
    private String currency;

    public Product(String productId, String name, String category, String brand,
                   double quantity, String unit, double price, String currency) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.quantity = quantity;
        this.unit = unit;
        this.price = price;
        this.currency = currency;
    }
}






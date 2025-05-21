package org.example.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Discount {
    private String productId;
    private String productName;
    private String brand;
    private double quantity;
    private String unit;
    private String category;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int percentage;


    public Discount(String productId, String productName, String brand, double quantity, String unit,
                    String category, LocalDate fromDate, LocalDate toDate, int percentage) {

        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.quantity = quantity;
        this.unit = unit;
        this.category = category;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.percentage = percentage;
    }
}

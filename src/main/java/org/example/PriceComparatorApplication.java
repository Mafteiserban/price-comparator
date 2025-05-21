package org.example;

import org.example.model.Product;
import org.example.util.CsvReaderUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PriceComparatorApplication {
    public static void main(String[] args) {


       List<Product> products=CsvReaderUtil.readProducts("kaufland_2025-05-08.csv");

       for(Product product:products){
           System.out.println(product);
       }

    }

}
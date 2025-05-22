package org.example;

import org.example.model.Discount;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.example.util.CsvReaderUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class PriceComparatorApplication {
    public static void main(String[] args) {


//       List<Product> products=CsvReaderUtil.readProducts("kaufland_2025-05-08.csv");
//
//       for(Product product:products){
//           System.out.println(product);
//       }
//
//        System.out.println("---------------------------------------------------------------------------");
//
//       List<Discount> discounts = CsvReaderUtil.readDiscounts(" kaufland_discounts_2025-05-08.csv");
//
//       for(Discount discount:discounts){
//           System.out.println(discount);
//       }
        ProductRepository repo = new ProductRepository();

        List<Product> products = repo.getProductsByStoreAndDate("lidl", LocalDate.of(2025, 5, 1));

        System.out.println("Produse Lidl - 2025-05-01:");
        for (Product product : products) {
            System.out.println(product);
        }

    }

}
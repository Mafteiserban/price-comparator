package org.example.util;

import org.example.model.Discount;
import org.example.model.Product;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class CsvReaderUtil {

    public static List<Product> readProducts(String fileName) {

        List<Product> products = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                CsvReaderUtil.class.getClassLoader().getResourceAsStream("data/" + fileName)))) {

            String line;
            boolean firstLine = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] values = line.split(";");
                if (values.length < 8) continue;

                Product product = new Product(
                        values[0],
                        values[1],
                        values[2],
                        values[3],
                        Double.parseDouble(values[4]),
                        values[5],
                        Double.parseDouble(values[6]),
                        values[7]
                );

                products.add(product);
            }

        } catch (IOException | NullPointerException e) {
            System.err.println("Eroare la citirea fisierului" + fileName + ": " + e.getMessage());
        }

        return products;
    }


    public static List<Discount> readDiscounts(String fileName) {

        List<Discount> discounts = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                CsvReaderUtil.class.getClassLoader().getResourceAsStream("data/" + fileName)))) {


            String line;
            boolean firstLine = true;

            while ((line = bufferedReader.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] values = line.split(";");
                if (values.length < 9)
                    continue;

                Discount discount = new Discount(
                        values[0],
                        values[1],
                        values[2],
                        Double.parseDouble(values[3]),
                        values[4],
                        values[5],
                        LocalDate.parse(values[6]),
                        LocalDate.parse(values[7]),
                        Integer.parseInt(values[8])
                );


                discounts.add(discount);
            }
        }catch (IOException | NullPointerException e){
            System.err.println("Error reading the file" + fileName + ": " + e.getMessage());
        }


        return discounts;
    }

}

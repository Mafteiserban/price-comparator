package org.example.util;

import org.example.model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderUtil {

    public static List<Product> readProducts(String fileName){

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
            System.err.println("Eroare la citirea fisierului " + fileName + ": " + e.getMessage());
        }

        return products;
    }



}

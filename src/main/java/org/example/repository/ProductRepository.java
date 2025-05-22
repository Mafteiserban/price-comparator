package org.example.repository;

import org.example.model.Product;
import org.example.util.CsvReaderUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductRepository {

    private final Map<String, Map<LocalDate, List<Product>>> cache = new HashMap<>();

    public List<Product> getProductsByStoreAndDate(String store, LocalDate date) {
        cache.putIfAbsent(store, new HashMap<>());
        Map<LocalDate, List<Product>> storeData = cache.get(store);

        if (!storeData.containsKey(date)) {
            String filename = store.toLowerCase() + "_" + date + ".csv";
            List<Product> products = CsvReaderUtil.readProducts(filename);
            storeData.put(date, products);
        }

        return storeData.get(date);
    }


}



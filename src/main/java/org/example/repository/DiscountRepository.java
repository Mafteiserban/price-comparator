package org.example.repository;

import org.example.model.Discount;
import org.example.util.CsvReaderUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DiscountRepository {

    private final  Map<String, Map<LocalDate, List<Discount>>> cache = new HashMap<>();

public List<Discount> getDiscountsByStoreAndDate(String store,LocalDate date){

    cache.putIfAbsent(store,new HashMap<>());
    Map<LocalDate,List<Discount>> storeDiscoutData = cache.get(store);

    if(!storeDiscoutData.containsKey(date)){

        String fileName =  store.toLowerCase() + "_discounts_" + date + ".csv";
        List<Discount> discounts = CsvReaderUtil.readDiscounts(fileName);
        storeDiscoutData.put(date,discounts);
    }
    return storeDiscoutData.get(date);
}
}

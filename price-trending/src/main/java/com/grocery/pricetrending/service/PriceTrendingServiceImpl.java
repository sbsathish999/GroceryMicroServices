package com.grocery.pricetrending.service;

import com.grocery.pricetrending.model.ItemPriceTrendingByYear;
import com.grocery.pricetrending.model.PriceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PriceTrendingServiceImpl implements PriceTrendingService{
    @Override
    public ItemPriceTrendingByYear getMaximumPriceDataByYear(String itemName, List<PriceData> saleList) {
        if(saleList != null && !saleList.isEmpty()) {
            Map<String, List<Float>> priceByDateMap = convertToPriceDateMap(saleList);
            Map<String, Float> maxPriceByDateMap = calculateMaximumPriceByYear(priceByDateMap);
            List<Float> prices = maxPriceByDateMap.values().stream().collect(Collectors.toList());
            List<String> years = maxPriceByDateMap.keySet().stream().collect(Collectors.toList());
            return new ItemPriceTrendingByYear(itemName, prices, years);
        }
        return null;
    }
    protected Map<String, Float> calculateMaximumPriceByYear(Map<String, List<Float>> priceByDateMap) {
        Map<String, Float> maxPriceByDateMap = new TreeMap<>();
        priceByDateMap
                .entrySet()
                .forEach( e-> maxPriceByDateMap.put(e.getKey()
                            , Float.valueOf(String.valueOf(e.getValue()
                                                            .stream()
                                                            .mapToDouble(a -> a)
                                                            .max()
                                                            .getAsDouble()))));
        return maxPriceByDateMap;
    }

    protected Map<String, List<Float>> convertToPriceDateMap(List<PriceData> priceByItems) {
        Map<String, List<Float>> priceByDateMap = new TreeMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        priceByItems.stream().forEach(pd -> {
            String year = null;
            try {
                year = yearFormat.format(dateFormat.parse(pd.getDate()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            if(priceByDateMap.get(year) == null) {
                priceByDateMap.put(year, new ArrayList<>(Arrays.asList(pd.getPrice())));
            } else {
                List<Float> currentPrices = priceByDateMap.get(year);
                currentPrices.add(pd.getPrice());
                priceByDateMap.put(year, currentPrices);
            }
        });
        return priceByDateMap;
    }
}

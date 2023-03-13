package com.grocery.pricetrending.service;

import com.grocery.pricetrending.model.ItemPriceTrendingByYear;
import com.grocery.pricetrending.model.PriceData;

import java.util.List;

public interface PriceTrendingService {
    ItemPriceTrendingByYear getMaximumPriceDataByYear(String itemName, List<PriceData> itemSaleList);
}

package com.grocery.pricetrending.controller;

import com.grocery.pricetrending.model.ItemPriceTrendingByYear;
import com.grocery.pricetrending.model.PriceData;
import com.grocery.pricetrending.service.PriceTrendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery")
public class PriceTrendingController {

    @Autowired
    PriceTrendingService priceTrendingService;

    @PostMapping(value = "/sale-list")
    public ResponseEntity getPriceTrendingSaleInformationByItem(@RequestBody List<PriceData> itemSaleList, @RequestParam String itemName){
        ItemPriceTrendingByYear result = priceTrendingService.getMaximumPriceDataByYear(itemName, itemSaleList);
        return result == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(result);
    }

}

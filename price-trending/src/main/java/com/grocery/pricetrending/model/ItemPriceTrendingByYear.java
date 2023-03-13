package com.grocery.pricetrending.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPriceTrendingByYear {
    String itemName;
    List<Float> prices;
    List<String> years;
}

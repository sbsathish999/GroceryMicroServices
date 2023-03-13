package com.grocery.pricetrending.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@Data
public class PriceData implements Serializable {
    //String datesk;
    String itemName;
    String date;
    Float price;
}

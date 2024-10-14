package com.techelevator.Items;

import java.util.ArrayList;
import java.util.List;

public class Chips{
    List<String> nameList = new ArrayList<>();
    List<Double> priceList = new ArrayList<>();

    public List<String> getNameList() {
        nameList.add("Potato Crisps");
        nameList.add("Stackers");
        nameList.add("Grain Waves");
        nameList.add("Cloud Popcorn");
        return nameList;
    }
    public List<Double> getPriceList(){
        priceList.add(3.05);
        priceList.add(1.45);
        priceList.add(2.75);
        priceList.add(3.65);
        return priceList;
    }

}

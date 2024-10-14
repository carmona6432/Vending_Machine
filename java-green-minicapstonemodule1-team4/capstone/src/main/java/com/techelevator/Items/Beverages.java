package com.techelevator.Items;

import java.util.ArrayList;
import java.util.List;

public class Beverages  {
    List<String> nameList = new ArrayList<>();
    List<Double> priceList = new ArrayList<>();

    public List<String> getNameList() {
        nameList.add("Cola");
        nameList.add("Dr. Salt");
        nameList.add("Mountain Melter");
        nameList.add("Heavy");
        return nameList;
    }
    public List<Double> getPriceList(){
        priceList.add(1.25);
        priceList.add(1.50);
        return priceList;
    }
}

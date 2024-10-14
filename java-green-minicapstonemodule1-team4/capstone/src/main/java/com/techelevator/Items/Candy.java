package com.techelevator.Items;

import java.util.ArrayList;
import java.util.List;

public class Candy{
    List<String> nameList = new ArrayList<>();
    List<Double> priceList = new ArrayList<>();

    public List<String> getNameList() {
        nameList.add("Moonpie");
        nameList.add("Cowtales");
        nameList.add("Wonka Bar");
        nameList.add("Crunchie");
        return nameList;
    }
    public List<Double> getPriceList(){
        priceList.add(1.80);
        priceList.add(1.50);
        priceList.add(1.75);
        return priceList;
    }
}

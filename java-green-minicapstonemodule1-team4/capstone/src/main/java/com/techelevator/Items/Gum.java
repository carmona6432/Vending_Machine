package com.techelevator.Items;

import java.util.ArrayList;
import java.util.List;

public class Gum {
    List<String> gumList = new ArrayList<>();
    List<Double> priceList = new ArrayList<>();

    public List<String> getGumList() {
        gumList.add("U-Chews");
        gumList.add("Little League Chew");
        gumList.add("Chiclets");
        gumList.add("Triplemint");
        return gumList;
    }
    public List<Double> getPriceList(){
        priceList.add(0.85);
        priceList.add(0.95);
        priceList.add(0.75);
        priceList.add(0.75);
        return priceList;
    }


}

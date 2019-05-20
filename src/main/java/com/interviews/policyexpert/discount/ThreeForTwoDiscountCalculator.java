package com.interviews.policyexpert.discount;

import com.interviews.policyexpert.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ThreeForTwoDiscountCalculator implements DiscountCalculator {

    private String itemName;

    public ThreeForTwoDiscountCalculator(String itemName) {
        this.itemName = itemName;
    }

    public double calculateDiscount(List<Item> basket) {

        List<Item> searchedList = basket.stream()
                    .filter(item -> itemName.equals(item.getName())).collect(Collectors.toList());

        if(searchedList.size()>2){
            return searchedList.get(0).getPrice();
        }

        return 0;
    }
}

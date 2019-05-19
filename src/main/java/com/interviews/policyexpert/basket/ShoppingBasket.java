package com.interviews.policyexpert.basket;

import com.interviews.policyexpert.model.Item;
import com.interviews.policyexpert.model.Receipt;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private List<Item> items;

    public void addItem(Item item){
        if(items==null){
            items = new ArrayList<Item>();
        }
        items.add(item);
    }

    public Receipt calculateReceipt(){
        double total = 0;

        for(Item item : items){
            System.out.println(item);
            total = total+item.getPrice();
        }

        Receipt receipt = new Receipt();
        receipt.setTotal(total);

        return receipt;
    }
}

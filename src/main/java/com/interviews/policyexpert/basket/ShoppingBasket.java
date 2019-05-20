package com.interviews.policyexpert.basket;

import com.interviews.policyexpert.discount.DiscountCalculator;
import com.interviews.policyexpert.model.Item;
import com.interviews.policyexpert.model.Receipt;
import lombok.Builder;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

@Builder
public class ShoppingBasket {

    @Singular
    private List<DiscountCalculator> discountCalculators;

    @Singular
    private List<Item> items;

    public ShoppingBasket withItem(Item item){

        List<Item> newItems = new ArrayList<>();
        newItems.addAll(items);
        newItems.add(item);

        ShoppingBasket newBasket = new ShoppingBasket(discountCalculators, newItems);

        return newBasket;
    }

    public Receipt calculateReceipt(){
        double total = 0;
        double savings = 0;

        for(Item item : items){
            total = total+item.getPrice();
        }

        for (DiscountCalculator discountCalculator : discountCalculators){
            double saving = discountCalculator.calculateDiscount(items);

            savings = savings + saving;
        }

        Receipt receipt = new Receipt();

        receipt.setSavings(savings);
        receipt.setSubTotal(total);
        receipt.setTotal(total - savings);

        System.out.println(receipt);

        return receipt;
    }
}

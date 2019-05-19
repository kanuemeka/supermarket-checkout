package com.interviews.policyexpert.basket;

import com.interviews.policyexpert.model.Item;
import com.interviews.policyexpert.model.Receipt;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket;

    @Before
    public void setup(){
        shoppingBasket = new ShoppingBasket();
    }

    @Test
    public void basketWithNoDiscountsShouldReturnExpectedValue()throws Exception{

        Item bean1 = new Item("Bean", 0.70);
        Item bean2 = new Item("Bean", 0.70);
        Item bean3 = new Item("Bean", 0.70);
        Item coke = new Item("Coke", 0.45);

        shoppingBasket.addItem(bean1);
        shoppingBasket.addItem(bean2);
        shoppingBasket.addItem(bean3);
        shoppingBasket.addItem(coke);

        Receipt receipt = shoppingBasket.calculateReceipt();

        assertNotNull(receipt);

    }
}

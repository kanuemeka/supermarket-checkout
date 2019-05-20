package com.interviews.policyexpert.basket;

import com.interviews.policyexpert.discount.ThreeForTwoDiscountCalculator;
import com.interviews.policyexpert.model.Item;
import com.interviews.policyexpert.model.Receipt;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingBasketTest {

    @Test
    public void basketWithNoDiscountsShouldReturnExpectedValue()throws Exception{

        ShoppingBasket shoppingBasket = ShoppingBasket.builder().build();

        Item bean1 = new Item("Beans", 0.70);
        Item bean2 = new Item("Beans", 0.70);
        Item bean3 = new Item("Beans", 0.70);
        Item coke = new Item("Coke", 0.45);

        double expectedTotal= 2.55;

        shoppingBasket = shoppingBasket.withItem(bean1);
        shoppingBasket = shoppingBasket.withItem(bean2);
        shoppingBasket = shoppingBasket.withItem(bean3);
        shoppingBasket = shoppingBasket.withItem(coke);

        Receipt receipt = shoppingBasket.calculateReceipt();

        assertNotNull(receipt);
        assertEquals(expectedTotal, receipt.getTotal(), 0);

    }

    @Test
    public void basketWith3For2DiscountShouldReturnReceiptWithSavings() throws Exception{

        ShoppingBasket shoppingBasket
                = ShoppingBasket.builder().discountCalculator(
                        new ThreeForTwoDiscountCalculator("Beans"))
                .build();

        Item bean1 = new Item("Beans", 0.70);
        Item bean2 = new Item("Beans", 0.70);
        Item bean3 = new Item("Beans", 0.70);
        Item coke = new Item("Coke", 0.45);

        double expectedSavings = 0.70;
        double expectedTotal= 2.55 - expectedSavings;

        shoppingBasket = shoppingBasket.withItem(bean1);
        shoppingBasket = shoppingBasket.withItem(bean2);
        shoppingBasket = shoppingBasket.withItem(bean3);
        shoppingBasket = shoppingBasket.withItem(coke);

        Receipt receipt = shoppingBasket.calculateReceipt();

        assertNotNull(receipt);
        assertEquals(expectedSavings, receipt.getSavings(), 0);
        assertEquals(expectedTotal, receipt.getTotal(), 0);
    }
}

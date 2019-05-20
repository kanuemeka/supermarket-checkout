package com.interviews.policyexpert.discount;

import com.interviews.policyexpert.model.Item;

import java.util.List;

/**
 * Calculates and returns the discount savings
 */
public interface DiscountCalculator {

    double calculateDiscount(List<Item> basket);
}

package com.interviews.policyexpert.model;

public class Receipt {

    private double subTotal;

    private double total;

    private double savings;

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("\n Receipt")
                .append("\n Sub Total \t"+subTotal)
                .append("\n Total Savings \t"+savings)
                .append("\n Total \t"+total)
                .toString();
    }
}

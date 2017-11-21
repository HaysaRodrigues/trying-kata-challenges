package com.haysarodrigues.items;

/**
 * @author haysa
 */
public class Grape implements Item {

    private int amount;
    private double unitValue = 0;

    public Grape(int amount) {
        this.amount = amount;
        filterIfHasSpecialPriceOrUnitPriceByItem(amount);
    }

    public int getAmount() {
        return amount;
    }

    public double getUnitValue() {
        return unitValue;
    }

    @Override
    public void filterIfHasSpecialPriceOrUnitPriceByItem(int amount) {

        if (amount >= 1 && amount <= 2) {
            unitValue = 1.35;

        } else if (amount >= 3 && amount < 10) {
            unitValue = 1.35;

        } else if (amount >= 10) {
            unitValue = 0.40;
        }
    }
}

package com.haysarodrigues.items;

/**
 * @author haysa
 */
public class Orange implements Item {

    private int amount;
    private double unitValue = 0;

    public Orange(int amount) {
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
            unitValue = 1.60;

        } else if (amount >= 3 && amount < 10) {
            unitValue = 1.25;

        } else if (amount >= 10) {
            unitValue = 0.30;
        }
    }
}

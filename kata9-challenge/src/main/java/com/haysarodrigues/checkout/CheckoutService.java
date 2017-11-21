package com.haysarodrigues.checkout;

import com.google.common.collect.ListMultimap;
import com.haysarodrigues.application.ItemList;
import com.haysarodrigues.items.Apple;
import com.haysarodrigues.items.Grape;
import com.haysarodrigues.items.Orange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haysa
 */
public class CheckoutService {

    /**
     * @param myHash
     * @return
     */
    public static HashMap<ItemList, Integer> scanItemsFromHash(ListMultimap<ItemList, Integer> myHash) {

        HashMap<ItemList, Integer> hashMapFinalValues = new HashMap<>();

        ItemList n = null;
        int sumAll;
        int total = 0;

        for (Map.Entry entry : myHash.entries()) {

            if (entry.getKey() != n) {
                n = (ItemList) entry.getKey();
                total = 0;
                hashMapFinalValues.put((ItemList) entry.getKey(), Integer.parseInt(entry.getValue().toString()));

            }
            sumAll = Integer.parseInt(entry.getValue().toString());
            total += sumAll;
            hashMapFinalValues.put((ItemList) entry.getKey(), total);

        }
        return hashMapFinalValues;
    }

    /**
     * @param map2
     * @return
     */
    public static List extractHashMapToMakeCheckout(HashMap<ItemList, Integer> map2) {

        List<String> listWithRespectivePrices = new ArrayList<>();

        for (Map.Entry entry : map2.entrySet()) {
            double sum = discoverItemToCalculatePrice((ItemList) entry.getKey(), Integer.parseInt(entry.getValue().toString()));
            listWithRespectivePrices.add(" \n | Item: " + entry.getKey()
                    + " Amount: " + Integer.parseInt(entry.getValue().toString())
                    + " Total to pay: " + sum + " | ");
        }

        System.out.println(listWithRespectivePrices);

        return listWithRespectivePrices;

    }

    /**
     * @param itemList
     * @param amount
     * @return
     */
    public static double discoverItemToCalculatePrice(ItemList itemList, int amount) {
        double result = 0;

        if (itemList == ItemList.APPLE) {
            Apple apple = new Apple(amount);
            result = calculateTotalWithAmountAndUnitValue(apple.getAmount(), apple.getUnitValue());

        } else if (itemList == ItemList.ORANGE) {
            Orange orange = new Orange(amount);
            result = calculateTotalWithAmountAndUnitValue(orange.getAmount(), orange.getUnitValue());

        } else if (itemList == ItemList.GRAPE) {
            Grape grape = new Grape(amount);
            result = calculateTotalWithAmountAndUnitValue(grape.getAmount(), grape.getUnitValue());
        }

        return result;
    }

    /**
     * @param amount
     * @param unitValue
     * @return
     */
    public static double calculateTotalWithAmountAndUnitValue(int amount, double unitValue) {
        double total = amount * unitValue;
        return total;
    }


}

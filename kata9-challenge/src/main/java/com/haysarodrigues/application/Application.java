package com.haysarodrigues.application;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.haysarodrigues.checkout.TheCheckout;
import com.haysarodrigues.items.Apple;
import com.haysarodrigues.items.Grape;
import com.haysarodrigues.items.Orange;

/**
 * @author haysa
 */
public class Application {

    public static void main(String[] args) {

        ListMultimap<ItemList, Integer> myHash = ArrayListMultimap.create();
        Apple apple = new Apple(1);
        Apple apple2 = new Apple( 1);
        Orange orange = new Orange(2);
        Orange orange2 = new Orange(2);
        Apple apple3 = new Apple(2);
        Grape grape = new Grape(5);

        myHash.put(ItemList.APPLE, apple.getAmount());
        myHash.put(ItemList.ORANGE, orange2.getAmount());
        myHash.put(ItemList.APPLE, apple2.getAmount());
        myHash.put(ItemList.GRAPE, grape.getAmount());
        myHash.put(ItemList.ORANGE, orange.getAmount());
        myHash.put(ItemList.APPLE, apple3.getAmount());
        System.out.println("PRINT DA MINHA HASHMAP" + myHash.toString());

        TheCheckout checkout = new TheCheckout();
        checkout.checkout(myHash);

    }
}

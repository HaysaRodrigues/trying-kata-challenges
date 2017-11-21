package com.haysarodrigues.checkout;

import com.google.common.collect.ListMultimap;
import com.haysarodrigues.application.ItemList;

import java.util.HashMap;

/**
 * @author haysa
 */
public class TheCheckout {


    public void checkout(ListMultimap<ItemList, Integer> myHash) {

        CheckoutService checkoutService = new CheckoutService();

        HashMap<ItemList, Integer> finalCartList;

        finalCartList = checkoutService.scanItemsFromHash(myHash);

        checkoutService.extractHashMapToMakeCheckout(finalCartList);

    }
}

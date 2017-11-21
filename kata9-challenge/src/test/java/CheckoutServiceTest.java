import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.haysarodrigues.application.ItemList;
import com.haysarodrigues.checkout.CheckoutService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author haysa
 */
public class CheckoutServiceTest {

    @Test
    public void calculateTotalWithAmountAndUnitValue_ShouldReturnTotalFifty_WhenSendAmout5AndUnitValue10(){

        int amount = 5;
        double unitValue = 10;
        double expectValue = 50.0;

        CheckoutService checkoutService = new CheckoutService();
        double actualResult = checkoutService.calculateTotalWithAmountAndUnitValue(amount, unitValue);
        Assert.assertTrue(actualResult == expectValue);

    }

    @Test
    public void calculateTotalWithAmountAndUnitValue_ShouldReturnTotalZero_IfUserSentZeroInOneOfTwoParameters(){

        int amount = 0;
        double unitValue = 0;
        double expectedValue = 0;
        CheckoutService checkoutService = new CheckoutService();

        double actualResult = checkoutService.calculateTotalWithAmountAndUnitValue(amount, unitValue);
        Assert.assertTrue(actualResult == expectedValue);

    }

    @Test
    public void discoverItemToCalculatePrice_ShouldCalculateAndReturnWithApplePrice_IfUserSentTheItemListAsApple(){
        int amount = 3;
        double expectedValue = 4.65;
        CheckoutService checkoutService = new CheckoutService();

        double actualResult = checkoutService.discoverItemToCalculatePrice(ItemList.APPLE, amount);
        Assert.assertTrue(actualResult == expectedValue);

    }

    @Test
    public void discoverItemToCalculatePrice_ShouldCalculateAndReturnWithOrangePrice_IfUserSentTheItemListAsOrange(){
        int amount = 3;
        double expectedValue = 3.75;
        CheckoutService checkoutService = new CheckoutService();

        double actualResult = checkoutService.discoverItemToCalculatePrice(ItemList.ORANGE, amount);
        Assert.assertTrue(actualResult == expectedValue);

    }

    @Test
    public void discoverItemToCalculatePrice_ShouldCalculateAndReturnWithGrapePrice_IfUserSentTheItemListAsGrape(){
        int amount = 3;
        double expectedValue = 4.050000000000001;
        CheckoutService checkoutService = new CheckoutService();


        double actualResult = checkoutService.discoverItemToCalculatePrice(ItemList.GRAPE, amount);
        Assert.assertTrue(actualResult == expectedValue);

    }

    @Test
    public void scanItemsFromHash_ShouldReturnNothing_WhenItsListMapHasNothingToScan(){
        CheckoutService checkoutService = new CheckoutService();
        ListMultimap<ItemList, Integer> myListMap = ArrayListMultimap.create();
        HashMap <ItemList, Integer> myListMapCheck;

        myListMapCheck = checkoutService.scanItemsFromHash(myListMap);
        Assert.assertTrue(myListMapCheck.isEmpty());
    }

    @Test
    public void scanItemsFromHash_ShouldReturnTheListMap_WhenItsListMapHasItemsWithItsKey(){
        CheckoutService checkoutService = new CheckoutService();
        ListMultimap<ItemList, Integer> myListMap = ArrayListMultimap.create();
        myListMap.put(ItemList.APPLE, 3);
        HashMap <ItemList, Integer> myListMapCheck;

        myListMapCheck = checkoutService.scanItemsFromHash(myListMap);

        Assert.assertTrue(myListMapCheck.containsKey(ItemList.APPLE));
    }

    @Test
    public void extractHashMapToMakeCheckout_ShouldReturnTheListMap_WhenItsListMapHasItemsWithItsKey(){
        CheckoutService checkoutService = new CheckoutService();
        ListMultimap<ItemList, Integer> myListMap = ArrayListMultimap.create();
        myListMap.put(ItemList.APPLE, 3);
        HashMap <ItemList, Integer> myListMapCheck;
        List<String> finalList = new ArrayList<>();

        myListMapCheck = checkoutService.scanItemsFromHash(myListMap);
        finalList = checkoutService.extractHashMapToMakeCheckout(myListMapCheck);

        Assert.assertTrue(finalList.get(0).contains("APPLE"));

    }

}
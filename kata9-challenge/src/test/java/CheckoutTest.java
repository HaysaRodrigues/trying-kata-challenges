import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.haysarodrigues.application.ItemList;
import com.haysarodrigues.checkout.TheCheckout;
import com.haysarodrigues.items.Apple;
import com.haysarodrigues.items.Grape;
import com.haysarodrigues.items.Orange;
import org.junit.Test;

/**
 * @author haysa
 */
public class CheckoutTest {

    @Test
    public void checkout_MakeCheckoutReturnsPrices_WithInputInRandomOrder() {
        ListMultimap<ItemList, Integer> myHash = ArrayListMultimap.create();
        TheCheckout checkout = new TheCheckout();
        Apple apple = new Apple(1);
        Orange orange = new Orange(2);
        Apple apple2 = new Apple(1);
        Grape grape = new Grape(2);

        myHash.put(ItemList.APPLE, apple.getAmount());
        myHash.put(ItemList.ORANGE, orange.getAmount());
        myHash.put(ItemList.APPLE, apple2.getAmount());
        myHash.put(ItemList.GRAPE, grape.getAmount());
        checkout.checkout(myHash);

        //TODO MOCK
    }

}
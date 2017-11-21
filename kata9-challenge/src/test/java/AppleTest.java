import com.haysarodrigues.items.Apple;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author haysa
 */
public class AppleTest {

    @Test
    public void filterIfHasSpecialPriceOrUnitPriceByItem_ShouldSetTheUnitValueOneAndFiftyFiveCents_WhenAmountIsMoreThanThree(){
        Apple apple = new Apple(3);

        double actualValue = apple.getUnitValue();
        Assert.assertTrue(actualValue == 1.55);

    }

    @Test
    public void filterIfHasSpecialPriceOrUnitPriceByItem_ShouldSetTheUnitValueOneAndEightyCents_WhenAmountIsLessThanTwo(){
        Apple apple = new Apple(2);

        double actualValue = apple.getUnitValue();
        Assert.assertTrue(actualValue == 1.80);

    }

    @Test
    public void filterIfHasSpecialPriceOrUnitPriceByItem_ShouldSetTheUnitValueFiftyCents_WhenAmountIsMoreThanTen(){
        Apple apple = new Apple(16);

        double actualValue = apple.getUnitValue();
        Assert.assertTrue(actualValue == 0.50);

    }

    @Test
    public void filterIfHasSpecialPriceOrUnitPriceByItem_ShouldSetTheUnitValueZero_IfAmountIsZero(){
        Apple apple = new Apple(0);

        double actualValue = apple.getUnitValue();
        Assert.assertTrue(actualValue == 0);

    }

}

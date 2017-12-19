import RG.RG;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author haysa
 */
public class RGTest {

    private RG validateRg;

    @Before
    public void setUp() {
        validateRg = new RG();
    }

    @Test
    public void isRGValid_MakeReturnTrue_WhenReceivesInputAsExpectedFormat() {
        Assert.assertTrue(validateRg.isRGValid("12864010-43"));
    }

    @Test
    public void isRGValid_MakeReturnFalse_WhenReceivesInputAsNull() {
        Assert.assertFalse(validateRg.isRGValid(null));
    }

    @Test
    public void isRGValid_MakeReturnFalse_WhenReceivesInputWithNoMask() {
        Assert.assertFalse(validateRg.isRGValid("1286401043"));
    }

    @Test
    public void isRGValid_MakeReturnFalse_WhenReceivesEmptyInput() {
        Assert.assertFalse(validateRg.isRGValid(""));
    }
}

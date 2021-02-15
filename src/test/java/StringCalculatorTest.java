import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testStringWithOneNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void testStringWithTwoNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(11, stringCalculator.add("5,6"));
    }

    @Test
    public void testStringWithAnyNumberOfNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(55, stringCalculator.add("1,2,3,4,5,6,7,8,9,10"));
    }
}

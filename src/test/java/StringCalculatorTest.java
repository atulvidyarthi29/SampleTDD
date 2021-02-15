import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testStringWithOneNumber(){
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void testStringWithTwoNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(11, stringCalculator.add("5,6"));
    }
}
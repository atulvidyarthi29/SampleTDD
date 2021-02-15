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

    @Test
    public void testNewLineSupport() {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void testWithDifferentDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(17, stringCalculator.add("//;\n1;2;5\n9"));
    }

    @Test(expected = Exception.class)
    public void testStringWithNegativeNumbers() {
        StringCalculator stringCalculator =  new StringCalculator();
        stringCalculator.add("//;\n1;2;-5\n9");
    }
}

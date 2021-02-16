import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void testEmptyString() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testStringWithOneNumber() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void testStringWithTwoNumber() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(11, stringCalculator.add("5,6"));
    }

    @Test
    public void testStringWithAnyNumberOfNumbers() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(55, stringCalculator.add("1,2,3,4,5,6,7,8,9,10"));
    }

    @Test
    public void testNewLineSupport() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void testWithDifferentDelimiter() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        Assert.assertEquals(17, stringCalculator.add("//;\n1;2;5\n9"));
    }

    @Test(expected = Exception.class)
    public void testStringWithOneNegativeNumbers() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.add("//;\n1;2;-5\n9");
    }

    @Test(expected = Exception.class)
    public void testStringWithMultipleNegativeNumbers() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.add("//;\n1;-2;-5\n-9");
    }
}

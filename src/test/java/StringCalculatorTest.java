import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void testEmptyString() throws Exception {
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testStringWithOneNumber() throws Exception {
        Assert.assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void testStringWithTwoNumber() throws Exception {
        Assert.assertEquals(11, stringCalculator.add("5,6"));
    }

    @Test
    public void testStringWithAnyNumberOfNumbers() throws Exception {
        Assert.assertEquals(55, stringCalculator.add("1,2,3,4,5,6,7,8,9,10"));
    }

    @Test
    public void testNewLineSupport() throws Exception {
        Assert.assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void testWithDifferentDelimiter() throws Exception {
        Assert.assertEquals(17, stringCalculator.add("//;\n1;2;5\n9"));
    }

    @Test(expected = Exception.class)
    public void testStringWithOneNegativeNumbers() throws Exception {
        stringCalculator.add("//;\n1;2;-5\n9");
    }

    @Test(expected = Exception.class)
    public void testStringWithMultipleNegativeNumbers() throws Exception {
        stringCalculator.add("//;\n1;-2;-5\n-9");
    }

    @Test
    public void testFunctionCount() {
        Assert.assertEquals(8, stringCalculator.getCalledCount());
    }
}

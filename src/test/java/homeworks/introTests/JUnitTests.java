package homeworks.introTests;

import org.junit.Assert;
import org.junit.Test;

public class JUnitTests {
    @Test
    public void unitTestOne() {
        MyNumbersTest myNumbersTest = new MyNumbersTest();
        Assert.assertEquals("Test failed!", 48, myNumbersTest.getNumber(-1, -1));
    }

    @Test
    public void unitTestTwo() {
        MyNumbersTest myNumbersTest = new MyNumbersTest();
        Assert.assertEquals("Test failed!", 50, myNumbersTest.getNumber(0, 10));
    }

    @Test
    public void unitTestThree() {
        MyNumbersTest myNumbersTest = new MyNumbersTest();
        Assert.assertEquals("Test failed!", 16, myNumbersTest.getNumber(-42, 8));
    }

    @Test
    public void unitTestFour() {
        MyNumbersTest myNumbersTest = new MyNumbersTest();
        Assert.assertEquals("Test failed!", 100, myNumbersTest.getNumber(0, 50));
    }
}

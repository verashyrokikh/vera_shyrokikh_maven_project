import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class TestNGTests {

    @Test
    public void unitTestOne() {
        MyNumbersTest myNumbersTest = new MyNumbersTest();
        assertEquals(myNumbersTest.getNumber(-1, -1), 48, "Test failed!");
    }

    @Test
    public void unitTestTwo() {
        MyNumbersTest myNumbersTest = new MyNumbersTest();
        assertEquals(myNumbersTest.getNumber(0, 10), 50, "Test failed!");
    }

    @Test
    public void unitTestThree() {
        MyNumbersTest myNumbersTest = new MyNumbersTest();
        assertEquals(myNumbersTest.getNumber(-42, 8), 16, "Test failed!");
    }

    @Test
    public void unitTestFour() {
        MyNumbersTest myNumbersTest = new MyNumbersTest();
        assertEquals(myNumbersTest.getNumber(0, 50), 100, "Test failed!");
    }
}

public class UnitTests {
    public static void main(String[] args) {
        MyNumbersTest myNumbersTest = new MyNumbersTest();
        int testOne = myNumbersTest.getNumber(-1, -1);
        if (testOne == 48) {
            System.out.println("Test one passed");
        } else {
            System.out.println("Test one failed");
        }

        int testTwo = myNumbersTest.getNumber(0, 10);
        if (testTwo == 50) {
            System.out.println("Test two passed");
        } else {
            System.out.println("Test two failed");
        }

        int testThree = myNumbersTest.getNumber(-42, 8);
        if (testThree == 16) {
            System.out.println("Test three passed");
        } else {
            System.out.println("Test three failed");
        }

        int testFour = myNumbersTest.getNumber(0, 50);
        if (testFour == 100) {
            System.out.println("Test four passed");
        } else {
            System.out.println("Test four failed");
        }
    }
}

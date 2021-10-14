package lesson_7_annotation_reflection;

import lesson_7_annotation_reflection.my_testing.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeSuite
    public static void initConnection() {
        System.out.println("Init connection data base");
    }

    @BeforeEach
    public void initForTests() {
        calculator = new Calculator();
        System.out.println("Before each, new Calculator");
    }

    @Test
    public static void staticTest() {
        System.out.println("Test with priority 5");
        System.out.println("Static test");
        System.out.println("-------------");
    }

    @Test(priority = 10)
    public void testSub() {
        System.out.println("Test with priority 10");
        Testing.equals(calculator.sub(5, 4), 1);
        System.out.println("-------------");
    }

    @Test(priority = 7)
    public void testMul() {
        System.out.println("Test with priority 7");
        Testing.equals(calculator.mul(1, 3), 3);
        System.out.println("-------------");
    }

    @Test(priority = 0)
    private void testDiv() {
        System.out.println("Test with priority 0");
        Testing.equals(calculator.div(4, 2), 2);
        System.out.println("-------------");
    }

    @AfterSuite
    public static void closeSomething() {
        System.out.println("Close Connection data base");
    }

}

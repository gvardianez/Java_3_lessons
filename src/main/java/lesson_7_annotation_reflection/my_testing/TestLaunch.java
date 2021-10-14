package lesson_7_annotation_reflection.my_testing;

import lesson_7_annotation_reflection.CalculatorTest;

public class TestLaunch {
    public static void main(String[] args) {
        StartTest.start(CalculatorTest.class);
    }
}
//  Консоль
//        Init connection data base
//        Before each, new Calculator
//        Test with priority 10
//        Test passed
//        -------------
//        Before each, new Calculator
//        Test with priority 7
//        Test passed
//        -------------
//        Before each, new Calculator
//        Test with priority 5
//        Static test
//        -------------
//        Before each, new Calculator
//        Test with priority 0
//        Test passed
//        -------------
//        Close Connection data base
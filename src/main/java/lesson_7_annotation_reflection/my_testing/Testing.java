package lesson_7_annotation_reflection.my_testing;

public class Testing {

    public static void equals(Object one, Object two) {
        if (one.equals(two)) {
            System.out.println("Test passed");
        } else System.out.println("Test failed");
    }
}

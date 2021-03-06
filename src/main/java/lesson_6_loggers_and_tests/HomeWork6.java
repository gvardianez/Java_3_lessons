package lesson_6_loggers_and_tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWork6 {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{0,1,0,1,5,4,2,5,1,5};
        System.out.println(Arrays.toString(arrayAfterLastFour(integers)));
    }

    public static Integer[] arrayAfterLastFour(Integer[] array) {
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
//        List<Integer> list = Arrays.stream(array).collect(Collectors.toCollection(ArrayList::new));
//        int count = 0;
//        for (int i = array.length; i > 0; i--) {
//            if (array[i - 1] == 4) {
//                Integer[] arrayResult = new Integer[count];
//                count = 0;
//                for (int j = i; j < array.length; j++) {
//                    arrayResult[count] = array[j];
//                    count++;
//                }
//                return arrayResult;
//            }
//            count++;
//        }
        if (list.contains(4)) {             //так явно поприятнее чем с циклами и массивами)
            list.subList(0, list.lastIndexOf(4) + 1).clear();
            return list.toArray(new Integer[0]);
        } else {
            throw new RuntimeException();
        }
//        throw new RuntimeException();
    }

    public static boolean checkArray(Integer[] array) {
//        for (Integer integer : array) {
//            if (integer == 1 || integer == 4) {
//                return true;
//            }
//        }
//        return false;
//
        return Arrays.asList(array).contains(1) || Arrays.asList(array).contains(4);
    }


}

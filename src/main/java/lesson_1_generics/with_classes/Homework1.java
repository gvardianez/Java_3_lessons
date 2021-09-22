package lesson_1_generics.with_classes;

import lesson_1_generics.with_classes.Apples.BlackPrince;
import lesson_1_generics.with_classes.Apples.Gala;
import lesson_1_generics.with_classes.Apples.Golden;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Homework1 {

    public static void main(String[] args) {
        Apple blackPrince = new BlackPrince(5.5f, 2.2);
        Apple gala =  new Gala(4,9.8);
        Apple golden =  new Golden(3,5.8);
        Box<Apple> box = new Box<>(50, List.of(BlackPrince.nameVariety, Gala.nameVariety));
        Box<Apple> box2 = new Box<>(50, List.of(BlackPrince.nameVariety,Golden.nameVariety));
        box.add(blackPrince);
        box.add(gala);
        System.out.println(box);
        System.out.println(box2);
        box.pour(box2,0,1);
        System.out.println(box);
        System.out.println(box2);
        box2.add(golden);
        System.out.println(box2);
    }

    public static <T> List<T> arrayToCollection(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static <T> T[] collectionToArray(Class<T> tClass, Collection<T> collection) {
        T[] array = (T[]) Array.newInstance(tClass, collection.size());
        return collection.toArray(array);
    }

    public static <T> void swap(T[] array, int indexOne, int indexTwo) {
        T temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    public static <T> T[] swapAndNewArray(T[] array, int indexOne, int indexTwo) {
        T[] newArray = Arrays.copyOf(array, array.length);
        T temp = newArray[indexOne];
        newArray[indexOne] = newArray[indexTwo];
        newArray[indexTwo] = temp;
        return newArray;
    }

}

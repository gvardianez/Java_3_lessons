package lesson_1_generics.with_enums;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Homework1 {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{4, 2, 8, 5, 9, 0, 4};
        List<Integer> integerListOne = arrayToCollectionOne(array);
        List<Integer> integerListTwo = arrayToCollectionTwo(array);
        List<Integer> integerListThree = arrayToCollectionThree(array);
        array = collectionToArray(Integer.class, integerListTwo);
        System.out.println(Arrays.toString(array));
        Apple gala = new Apple(5.6f, AppleVarieties.Gala);
        Apple blackPrince = new Apple(4.1f, AppleVarieties.BlackPrince);
        Apple golden = new Apple(1.5f, AppleVarieties.Golden);
        Orange moro = new Orange(3.3f, OrangeVarieties.Moro);
        Orange hamlin = new Orange(7.7f, OrangeVarieties.Hamlin);
        Orange verna = new Orange(4.5f, OrangeVarieties.Verna);
        Box<Orange> box1 = new Box<>(130);
        Box<Apple> box2 = new Box<>(180);
        Box<Apple> box3 = new Box<>(88, AppleVarieties.Gala, AppleVarieties.Golden);
        box1.add(moro);
        box1.add(hamlin);
        box1.add(verna);
        box2.add(blackPrince);
        box2.add(gala);
        box3.add(golden);
        System.out.println(box2);
        box2.sort();
        System.out.println(box2);
        System.out.println(box3);
//      box3.add(blackPrince);
//      box2.pour(box3);            ошибка в рантайме неправильные сорта
        box3.pour(box2);
        System.out.println("------------------------------------------");
        System.out.println(box2);
        System.out.println(box3);
        box2.pour(box3, 0, 1);
        System.out.println("-------------------------------------------");
        System.out.println(box2);
        System.out.println(box3);
        List<Box> boxListOne = new ArrayList<>();
        boxListOne.add(box1);
        boxListOne.add(box2);
        boxListOne.add(box3);
        Collections.sort(boxListOne);
        System.out.println(boxListOne);
        Example<Integer> integerExample = new Example<>(); //это из твоего примера из лекции, так то все работает нормально, но ошибку в рантайме я все же получил, вызвав метод getClass:)
//      integerExample.getArray().getClass();
    }

    public static <T> List<T> arrayToCollectionOne(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static <T> List<T> arrayToCollectionTwo(T[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    public static <T> List<T> arrayToCollectionThree(T[] array) {
        return Arrays.stream(array).collect(Collectors.toCollection(ArrayList::new));
    }

    public static <T> T[] collectionToArray(Class<T> tClass, Collection<T> collection) {   // для разнообразия коллекцию в массив
//        return (T[]) collection.toArray();  таким простым подходом выдает ClassCastException, как я понимаю потому что мы пытаемся Object закастить в какой-то тип Т в рантайме. Еще что-то читал про инвариативность дженериков.
        return collection.toArray((T[]) Array.newInstance(tClass, collection.size()));
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

// Консоль
//    [4, 2, 8, 5, 9, 0, 4]
//Box{listOfFruit=[Apple{variety=BlackPrince, totalPrice=47.96999888420105, weight=4.1}, Apple{variety=Gala, totalPrice=35.27999939918518, weight=5.6}], varieties=[], maxWeight=180.0, currentWeight=9.7, price=83.24999828338622}
//Box{listOfFruit=[Apple{variety=Gala, totalPrice=35.27999939918518, weight=5.6}, Apple{variety=BlackPrince, totalPrice=47.96999888420105, weight=4.1}], varieties=[], maxWeight=180.0, currentWeight=9.7, price=83.24999828338622}
//Box{listOfFruit=[Apple{variety=Golden, totalPrice=8.25, weight=1.5}], varieties=[Gala, Golden], maxWeight=88.0, currentWeight=1.5, price=8.25}
//------------------------------------------
//Box{listOfFruit=[Apple{variety=Gala, totalPrice=35.27999939918518, weight=5.6}, Apple{variety=BlackPrince, totalPrice=47.96999888420105, weight=4.1}, Apple{variety=Golden, totalPrice=8.25, weight=1.5}], varieties=[], maxWeight=180.0, currentWeight=11.2, price=91.49999828338622}
//Box{listOfFruit=[], varieties=[Gala, Golden], maxWeight=88.0, currentWeight=0.0, price=0.0}
//-------------------------------------------
//Box{listOfFruit=[Apple{variety=BlackPrince, totalPrice=47.96999888420105, weight=4.1}, Apple{variety=Golden, totalPrice=8.25, weight=1.5}], varieties=[], maxWeight=180.0, currentWeight=5.6, price=56.21999888420104}
//Box{listOfFruit=[Apple{variety=Gala, totalPrice=35.27999939918518, weight=5.6}], varieties=[Gala, Golden], maxWeight=88.0, currentWeight=5.6, price=35.27999939918518}
//[Box{listOfFruit=[Apple{variety=Gala, totalPrice=35.27999939918518, weight=5.6}], varieties=[Gala, Golden], maxWeight=88.0, currentWeight=5.6, price=35.27999939918518}, Box{listOfFruit=[Apple{variety=BlackPrince, totalPrice=47.96999888420105, weight=4.1}, Apple{variety=Golden, totalPrice=8.25, weight=1.5}], varieties=[], maxWeight=180.0, currentWeight=5.6, price=56.21999888420104}, Box{listOfFruit=[Orange{totalPrice=50.81999926567078, weight=3.3, variety=Moro}, Orange{totalPrice=74.68999814987183, weight=7.7, variety=Hamlin}, Orange{totalPrice=39.6, weight=4.5, variety=Verna}], varieties=[], maxWeight=130.0, currentWeight=15.5, price=165.1099974155426}]
//
//Process finished with exit code 0

}

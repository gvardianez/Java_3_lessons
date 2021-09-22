package lesson_1_generics.with_classes;

import lesson_1_generics.with_enums.WrongVarietyException;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box<T>> {

    private final List<T> listOfFruit = new ArrayList<>();
    private final List<String> varieties;
    private final float maxWeight;
    private float currentWeight;
    private double price;

    public Box(float maxWeight, List<String> varieties) {
        this.maxWeight = maxWeight;
        this.varieties = varieties;
    }

    public Box(float maxWeight) {
        this.maxWeight = maxWeight;
        this.varieties = new ArrayList<>();
    }

    public double getPrice() {
        return price;
    }

    public List<T> getListOfFruit() {
        return listOfFruit;
    }

    public boolean add(T fruit) {
        if (!(varieties.size() == 0)) {
            if (!varieties.contains(fruit.getNameVariety())) {
                throw new WrongVarietyException("Invalid fruit variety");
            }
        }
        if ((currentWeight + fruit.getWeight()) > maxWeight) {
            System.out.println("Excess weight");
            return false;
        }
        listOfFruit.add(fruit);
        currentWeight += fruit.getWeight();
        price += fruit.getTotalPrice();
        return true;
    }

    public float getCurrentWeight() {
        return currentWeight;
    }

    public boolean compareWeight(Box<T> box) {
        return this.currentWeight == box.currentWeight;
    }

    public boolean pour(Box<T> box) {
        if (!(box.varieties.size() == 0)) {
            if (!box.varieties.containsAll(this.varieties)) {
                throw new WrongVarietyException("Incorrect lists of fruit varieties");
            }
        }
        if ((this.currentWeight + box.currentWeight > box.maxWeight)) {
            System.out.println("Excess weight");
            return false;
        }
        box.listOfFruit.addAll(this.listOfFruit);
        box.currentWeight += this.currentWeight;
        box.price += this.price;
        this.price = 0;
        this.listOfFruit.clear();
        this.currentWeight = 0;
        return true;
    }

    public boolean pour(Box<T> box, int start, int end) {
        List<T> partList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            partList.add(this.listOfFruit.get(i));
        }
        if (!(box.varieties.size() == 0)) {
            List<String> stringList = new ArrayList<>();
            partList.forEach(a -> stringList.add(a.getNameVariety()));
            if (!box.varieties.containsAll(stringList)) {
                throw new WrongVarietyException("Incorrect lists of fruit varieties");
            }
        }
        float tempWeight = 0.f;
//     Stream<Float> floatStream = partList.stream().map(Fruit::getWeight);
//        tempWeight = floatStream.reduce(Float::sum).get();
        for (T t : partList) {                    //мне кажется циклом попроще
          tempWeight += t.getWeight();
        }
        if ((tempWeight + box.currentWeight > box.maxWeight)) {
            System.out.println("Excess weight");
            return false;
        }
        double tempPrice = 0;
        for (T t : partList) {
            tempPrice += t.getTotalPrice();
        }
        box.listOfFruit.addAll(partList);
        this.listOfFruit.removeAll(partList);
        box.currentWeight += tempWeight;
        this.currentWeight -= tempWeight;
        box.price += tempPrice;
        this.price -= tempPrice;
        return true;
    }

    @Override
    public int compareTo(Box o) {
        if (Float.compare(this.currentWeight, o.currentWeight) == 0) {
            return Double.compare(this.price, o.price);
        } else
            return Float.compare(this.currentWeight, o.currentWeight);
    }

    @Override
    public String toString() {
        return "Box{" +
                "listOfFruit=" + listOfFruit +
                ", varieties=" + varieties +
                ", maxWeight=" + maxWeight +
                ", currentWeight=" + currentWeight +
                ", price=" + price +
                '}';
    }
}

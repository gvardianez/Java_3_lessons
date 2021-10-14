package lesson_1_generics.with_enums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box<?>> {

    private final List<T> listOfFruit = new ArrayList<>();
    private final List<? extends Varieties> varieties;
    private final float maxWeight;
    private float currentWeight;
    private double price;

    @SafeVarargs
    public <T1 extends Enum<?> & Varieties> Box(float maxWeight, T1... varieties) {  //если хотим создать коробку с указанием определенных сортов
        this.maxWeight = maxWeight;
        this.varieties = List.of(varieties);
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
            if (!varieties.contains(fruit.getVariety())) {
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

    public boolean compareWeight(Box<?> box) {
        return Math.abs(this.currentWeight - box.currentWeight) < 0.0001;
    }

    public void sort(){   // отсортировать фрукты в коробке сначала по цене, затем по весу по возрастанию
        this.getListOfFruit().sort(Comparator.comparingDouble(Fruit::getTotalPrice).thenComparingDouble(Fruit::getWeight));  // выглядит запись с этими метод референсами конечно коротко, но мне кажется что со старыми добрыми анонимными классами нагляднее
    }

    public boolean pour(Box<T> box) {
        this.pour(box, 0, this.listOfFruit.size());
        return true;
    }

    public boolean pour(Box<T> box, int start, int end) {
        List<T> partList = this.listOfFruit.subList(start,end);
//        for (int i = start; i < end; i++) {
//            partList.add(this.listOfFruit.get(i));
//        }
        if (!(box.varieties.size() == 0)) {
            List<Enum<? extends Varieties>> enums = new ArrayList<>();
            partList.forEach(a -> enums.add(a.getVariety()));
            if (!box.varieties.containsAll(enums)) {
                throw new WrongVarietyException("Incorrect lists of fruit varieties");
            }
        }
        float tempWeight = 0.f;
//        tempWeight = partList.stream().map(Fruit::getWeight).reduce(Float::sum).get(); с потоком сложнее явно выглядит
        for (T t : partList) {
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
//        this.listOfFruit.removeAll(partList);
//        partList.forEach(listOfFruit::remove);
        partList.clear();
        box.currentWeight += tempWeight;
        this.currentWeight -= tempWeight;
        box.price += tempPrice;
        this.price -= tempPrice;
        return true;
    }

    @Override
    public int compareTo(Box o) {
        if (Math.abs(this.currentWeight - o.currentWeight) < 0.0001) {
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

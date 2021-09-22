package lesson_1_generics.with_enums;

public class Apple extends Fruit {

    private final Enum<? extends Varieties> variety;

    public <T extends Enum<T> & Varieties> Apple(float weight, T variety) {  //при создании яблока, необходимо указать сорт, который должен являться перечислением реализующим интерфейс Сорта
        this.weight = weight;
        this.variety = variety;
        totalPrice = variety.getUnitPrice() * weight;
    }

    @Override
    public Enum<? extends Varieties> getVariety() {
        return variety;
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "variety=" + variety +
                ", totalPrice=" + totalPrice +
                ", weight=" + weight +
                '}';
    }
}

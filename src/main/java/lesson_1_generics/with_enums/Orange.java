package lesson_1_generics.with_enums;

public class Orange extends Fruit{

    private final Enum<? extends Varieties> variety;

    public <T extends Enum<T> & Varieties> Orange(float weight,T variety) {
        this.weight = weight;
        this.variety = variety;
        totalPrice = variety.getUnitPrice() * weight;
    }

    @Override
    public float getWeight() {
        return weight;
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
    public String toString() {
        return "Orange{" +
                "totalPrice=" + totalPrice +
                ", weight=" + weight +
                ", variety=" + variety +
                '}';
    }
}

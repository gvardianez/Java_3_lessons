package lesson_1_generics.with_classes.Apples;

import lesson_1_generics.with_classes.Apple;

public class Golden extends Apple {

    public static final String nameVariety = "GOLDEN";
    private final double totalPrice;

    public Golden(float weight, double unitPrice) {
        this.weight = weight;
        this.unitPrice = unitPrice;
        this.totalPrice = unitPrice * weight;
    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String getNameVariety() {
        return nameVariety;
    }

    @Override
    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "Golden{" +
                "nameVariety=" + nameVariety +
                ", totalPrice=" + totalPrice +
                ", unitPrice=" + unitPrice +
                ", weight=" + weight +
                '}';
    }
}

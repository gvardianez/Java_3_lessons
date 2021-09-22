package lesson_1_generics.with_classes.Oranges;

import lesson_1_generics.with_classes.Orange;

public class Hamlin extends Orange {
    public static final String nameVariety = "HAMLIN";
    private final double totalPrice;

    public Hamlin(float weight, double unitPrice) {
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
        return "Hamlin{" +
                "nameVariety=" + nameVariety +
                ", unitPrice=" + unitPrice +
                ", weight=" + weight +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

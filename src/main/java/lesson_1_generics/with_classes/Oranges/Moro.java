package lesson_1_generics.with_classes.Oranges;

import lesson_1_generics.with_classes.Orange;

public class Moro extends Orange {
    public static final String nameVariety = "MORO";
    private final double totalPrice;

    public Moro(float weight, double unitPrice) {
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
        return "Moro{" +
                "nameVariety=" + nameVariety +
                ", unitPrice=" + unitPrice +
                ", weight=" + weight +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

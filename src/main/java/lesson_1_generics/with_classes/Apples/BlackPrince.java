package lesson_1_generics.with_classes.Apples;


import lesson_1_generics.with_classes.Apple;

public class BlackPrince extends Apple {

    public static final String nameVariety = "BLACK_PRINCE";
    private final double totalPrice;

    public BlackPrince(float weight, double unitPrice) {
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
        return "BlackPrince{" +
                "nameVariety=" + nameVariety +
                ", totalPrice=" + totalPrice +
                ", unitPrice=" + unitPrice +
                ", weight=" + weight +
                '}';
    }
}

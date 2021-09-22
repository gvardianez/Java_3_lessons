package lesson_1_generics.with_enums;

public abstract class Fruit {

    protected double totalPrice;
    protected float weight;

    public abstract float getWeight();

    public abstract Enum<? extends Varieties> getVariety();

    public abstract double getTotalPrice();

}

package lesson_1_generics.with_enums;

public enum OrangeVarieties implements Varieties{

    Hamlin(9.7),Verna(8.8),Moro(15.4);

    private final double price;

    OrangeVarieties(double price) {
        this.price = price;
    }

    public double getUnitPrice() {
        return price;
    }
}

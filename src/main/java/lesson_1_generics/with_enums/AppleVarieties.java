package lesson_1_generics.with_enums;

public enum AppleVarieties implements Varieties {

    Golden(5.5),Gala(6.3),BlackPrince(11.7);

    private final double price;

    AppleVarieties(double price) {
        this.price = price;
    }

    public double getUnitPrice() {
        return price;
    }
}

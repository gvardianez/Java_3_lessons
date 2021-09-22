package lesson_1_generics.with_enums;

public class Example<R> {
    private R[] array;

    public Example(){
        this.array = (R[]) new Object[10];
    }

    public R[] getArray() {
        return array;
    }

}

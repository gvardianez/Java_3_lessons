package lesson_5_synchronized;

import java.util.Objects;

public abstract class Stage {

    protected double length;
    protected String description;

    public abstract void pass(Car car);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return Double.compare(stage.length, length) == 0 && Objects.equals(description, stage.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, description);
    }
}

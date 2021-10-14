package lesson_5_synchronized;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class Car {

    protected double speed;
    protected String title;
    protected Map<Race<?>,Integer> competition;
    protected static final ReadWriteLock LOCK = new ReentrantReadWriteLock();

    public double getSpeed() {
        return speed;
    }

    public Map<Race<?>, Integer> getCompetition() {
        return competition;
    }

    public String getTitle() {
        return title;
    }

    public abstract void toRace(Race<?> race);

    @Override
    public String toString() {
        return "Car{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.speed, speed) == 0 && Objects.equals(title, car.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, title);
    }
}

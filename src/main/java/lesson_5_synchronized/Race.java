package lesson_5_synchronized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

public class Race<T extends Car> {
    private boolean isWinner;
    private int carPosition;
    private final String title;
    private final List<T> members;
    private final List<Car> resultOfRace;
    private final List<Stage> stages;
    private final ExecutorService executorService;
    private final CyclicBarrier cyclicBarrier;

    public Race(String title, List<T> members, Stage... stages) {
        this.title = title;
        this.members = members;
        this.resultOfRace = new ArrayList<>();
        this.stages = Arrays.asList(stages);
        this.executorService = Executors.newFixedThreadPool(members.size());
        this.cyclicBarrier = new CyclicBarrier(members.size(), () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка " + this.title + " началась!!!"));
    }

    public List<Stage> getStages() {
        return stages;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public int getCarPosition() {
        carPosition++;
        return carPosition;
    }

    public List<Car> getResultOfRace() {
        return resultOfRace;
    }

    public void start() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка к " + this.title + "!!!");
        for (T member : members) {
            executorService.execute(() -> member.toRace(this));
        }
        try {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка " + this.title + " закончилась!!!");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Результаты гонки:");
        for (int i = 0; i < resultOfRace.size(); i++) {
            System.out.println(i + 1 + ". " + resultOfRace.get(i).getTitle());
        }
    }

    @Override
    public String toString() {
        return "Race{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race<?> race = (Race<?>) o;
        return Objects.equals(title, race.title) && Objects.equals(members, race.members) && Objects.equals(stages, race.stages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, members, stages);
    }
}

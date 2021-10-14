package lesson_5_synchronized;

import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;

public class FormulaOneCar extends Car {

    public FormulaOneCar(String title, int speed) {
        this.speed = speed;
        this.title = title;
        competition = new HashMap<>();
    }

    public void toRace(Race<?> race) {
        try {
            System.out.println(this.title + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.title + " готов");
            race.getCyclicBarrier().await();
            for (Stage stage : race.getStages()) {
                stage.pass(this);
            }
            LOCK.writeLock().lock();
            if (!race.isWinner()) {
                System.out.println(this.getTitle() + " WIN!");
                race.setWinner(true);
                race.getCarPosition();
                competition.put(race, 1);
            } else {
                int position = race.getCarPosition();
                System.out.printf("%s завершил гонку на %d месте\n", this.getTitle(), position);
                competition.put(race, position);
            }
            race.getResultOfRace().add(this);
        }catch (InterruptedException |BrokenBarrierException e) {
            e.printStackTrace();
        }finally {
            LOCK.writeLock().unlock();
        }
    }
}

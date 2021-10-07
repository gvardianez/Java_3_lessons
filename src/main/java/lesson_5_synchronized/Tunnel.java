package lesson_5_synchronized;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private final Semaphore semaphore;

    public Tunnel(int length, int maxMembers) {
        this.length = length;
        this.description = "Тоннель " + length + " метров";
        this.semaphore = new Semaphore(maxMembers, true);
    }

    @Override
    public void pass(Car car) {
        try {
            System.out.println(car.getTitle() + " проверяет светофор на этапе: " + description);
            if (!semaphore.tryAcquire()) {
                System.out.println(car.getTitle() + " ждет разрешения на светофоре на этапе " + description);
                semaphore.acquire();
            }
            System.out.println(car.getTitle() + " получает разрешение на светофоре и начинает этап " + description);
            Thread.sleep((long) (length / car.getSpeed() * 1000L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(car.getTitle() + " закончил этап: " + description);
            semaphore.release();
        }
    }

}

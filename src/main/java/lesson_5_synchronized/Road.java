package lesson_5_synchronized;

public class Road extends Stage {

    public Road(double length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void pass(Car car) {
        try {
            System.out.println(car.getTitle() + " начал этап: " + description);
            Thread.sleep((long) (length / car.getSpeed() * 1000));
            System.out.println(car.getTitle() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

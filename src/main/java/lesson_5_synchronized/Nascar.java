package lesson_5_synchronized;

public class Nascar extends Car{

    public Nascar(String title, int speed) {
        this.speed = speed;
        this.title = title;
    }

    @Override
    public void toRace(Race<?> race) {
    //какая то логика для машин гонок Nascar
    }
}

package lesson_5_synchronized;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FormulaOneCar ferrari = new FormulaOneCar("Ferrari F1", 15);
        List<FormulaOneCar> formulaOneCarList = List.of(ferrari, new FormulaOneCar("Mercedes Benz", 13), new FormulaOneCar("Red Bull", 11), new FormulaOneCar("Aston Martin", 9));
        Race<FormulaOneCar> monacoGranPri = new Race<>("Гран при Монако", formulaOneCarList, new Road(30), new Tunnel(15, 2), new Road(20));
        monacoGranPri.start();
        System.out.printf("Болид %s, участие в гонках:\n" + ferrari.getCompetition(), ferrari.getTitle());
    }

//    Консоль
//    ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка к Гран при Монако!!!
//    Red Bull готовится
//    Aston Martin готовится
//    Mercedes Benz готовится
//    Ferrari F1 готовится
//    Aston Martin готов
//    Mercedes Benz готов
//    Ferrari F1 готов
//    Red Bull готов
//    ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка Гран при Монако началась!!!
//    Aston Martin начал этап: Дорога 30.0 метров
//    Red Bull начал этап: Дорога 30.0 метров
//    Ferrari F1 начал этап: Дорога 30.0 метров
//    Mercedes Benz начал этап: Дорога 30.0 метров
//    Ferrari F1 закончил этап: Дорога 30.0 метров
//    Ferrari F1 проверяет светофор на этапе: Тоннель 15 метров
//    Ferrari F1 получает разрешение на светофоре и начинает этап Тоннель 15 метров
//    Mercedes Benz закончил этап: Дорога 30.0 метров
//    Mercedes Benz проверяет светофор на этапе: Тоннель 15 метров
//    Mercedes Benz получает разрешение на светофоре и начинает этап Тоннель 15 метров
//    Red Bull закончил этап: Дорога 30.0 метров
//    Red Bull проверяет светофор на этапе: Тоннель 15 метров
//    Red Bull ждет разрешения на светофоре на этапе Тоннель 15 метров
//    Ferrari F1 закончил этап: Тоннель 15 метров
//    Ferrari F1 начал этап: Дорога 20.0 метров
//    Red Bull получает разрешение на светофоре и начинает этап Тоннель 15 метров
//    Aston Martin закончил этап: Дорога 30.0 метров
//    Aston Martin проверяет светофор на этапе: Тоннель 15 метров
//    Aston Martin ждет разрешения на светофоре на этапе Тоннель 15 метров
//    Mercedes Benz закончил этап: Тоннель 15 метров
//    Mercedes Benz начал этап: Дорога 20.0 метров
//    Aston Martin получает разрешение на светофоре и начинает этап Тоннель 15 метров
//    Ferrari F1 закончил этап: Дорога 20.0 метров
//    Ferrari F1 WIN!
//    Red Bull закончил этап: Тоннель 15 метров
//    Red Bull начал этап: Дорога 20.0 метров
//    Mercedes Benz закончил этап: Дорога 20.0 метров
//    Mercedes Benz завершил гонку на 2 месте
//    Aston Martin закончил этап: Тоннель 15 метров
//    Aston Martin начал этап: Дорога 20.0 метров
//    Red Bull закончил этап: Дорога 20.0 метров
//    Red Bull завершил гонку на 3 месте
//    Aston Martin закончил этап: Дорога 20.0 метров
//    Aston Martin завершил гонку на 4 месте
//    ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка Гран при Монако закончилась!!!
//    ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Результаты гонки:
//    1. Ferrari F1
//    2. Mercedes Benz
//    3. Red Bull
//    4. Aston Martin
//    Болид Ferrari F1, участие в гонках:
//    {Race{title='Гран при Монако'}=1}
//    Process finished with exit code 0

}

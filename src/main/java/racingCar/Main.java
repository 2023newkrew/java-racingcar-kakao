package racingCar;

public class Main {
    public static Car[] namesToCars(String input) {
        String[] names = input.split(",");
        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }
}

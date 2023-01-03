package racing_car.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    private List<Car> cars;
    private int round;

    public Racing(){}
    public Racing(String names, int round) {
        createCars(names);
        setRound(round);
    }

    public void createCars(String testNames) {
        createCars(testNames, new int[testNames.split(",").length]);
    }

    public void createCars(String testNames, int[] distances) {
        String[] names = testNames.split(",");
        cars = IntStream.range(0, names.length)
                .mapToObj(i->new Car(names[i], distances[i]))
                .collect(Collectors.toList());
    }

    private void setRound(int round) {
        this.round = round;
    }


    public List<Car> getCars() {
        return cars;
    }
    public boolean isEnd() {
        return this.round == 0;
    }

    public Car[] getWinners() {
        Car maxDistance = cars.stream().max(Comparator.naturalOrder()).get();
        return cars.stream()
                .filter(car -> car.compareTo(maxDistance) == 0)
                .collect(Collectors.toList())
                .toArray(Car[]::new);
    }

    protected int generateValue() {
        return new Random().nextInt(10);
    }

    public void race() {
        if (round == 0){
            return;
        }

        for (Car car: cars) {
            car.proceed(generateValue());
        }

        round--;
    }
}

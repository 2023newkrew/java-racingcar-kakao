package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    public static final int BOUND = 10;
    public static final String DELIMITER = ",";

    private final List<Car> cars = new ArrayList<>();
    private final int tryNo;
    private final Random random;

    private int no = 0;

    public RacingGame(String carNames, int tryNo, Random random) {
        createCars(carNames);
        this.tryNo = tryNo;
        this.random = random;
    }

    private void createCars(String names) {
        for (String name : names.split(DELIMITER)) {
            cars.add(new Car(name));
        }
    }

    public void race() {
        for (Car car : cars) {
            car.moveByCondition(random.nextInt(BOUND));
        }
        no++;
    }

    public String getWinners() {
        Car maxCar = Collections.max(cars);
        return cars.stream()
                .filter(c -> c.compareTo(maxCar) == 0)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    public boolean isEnd() {
        return no < tryNo;
    }
}

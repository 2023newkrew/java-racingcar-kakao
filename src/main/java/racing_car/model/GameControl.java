package racing_car.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

public class GameControl {

    public int generateRandomNumber() {
        return new Random().nextInt(10);
    }

    public void carControl(Car car, int number) {
        if (number >= 4){
            car.move(1);
        }
    }

    public Car[] getWinners(Car[] cars) {
        Car maxDistance = Arrays.stream(cars).max(Comparator.naturalOrder()).get();
        return Arrays.stream(cars)
                .filter(car -> car.compareTo(maxDistance) == 0)
                .collect(Collectors.toList())
                .toArray(Car[]::new);
    }
}

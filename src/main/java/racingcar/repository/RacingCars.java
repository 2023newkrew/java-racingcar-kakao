package racingcar.repository;

import racingcar.model.Car;
import racingcar.model.RacingCar;
import racingcar.util.Movable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final ArrayList<RacingCar> cars;

    public RacingCars(String[] cars) {
        this.cars = generateCarsListFromCarNames(cars);
    }
    private ArrayList<RacingCar> generateCarsListFromCarNames(String[] cars) {
        ArrayList<RacingCar> temp = new ArrayList<>();
        for (String carName : cars) {
            temp.add(new RacingCar(carName));
        }
        return temp;
    }

    public void moveCars(Movable movable) {
        for (Car car : cars) {
            car.move(movable);
        }
    }

    public List<RacingCar> getWinners() {
        RacingCar winner = Collections.max(cars);
        return cars.stream()
                .filter(car -> winner.compareTo(car) == 0)
                .collect(Collectors.toList());
    }

    public ArrayList<RacingCar> getCars() {
        return cars;
    }
}

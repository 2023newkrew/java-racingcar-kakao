package racingcar.domain.racing;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarDTO;
import racingcar.domain.car.RandomMovingAction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
    private final List<Car> racingCar = new ArrayList<>();

    RacingCar(List<String> carNames) {
        if (isDuplicateNames(carNames)) throw new IllegalArgumentException("");

        for (String carName : carNames)
            racingCar.add(new Car(carName));
    }

    public List<CarDTO> getCarDTOs() {
        return racingCar.stream().map(Car::toDTO).collect(Collectors.toList());
    }

    public void move() {
        racingCar.forEach(car -> car.move(new RandomMovingAction()));
    }

    public static boolean isDuplicateNames(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RacingCar)) return false;

        RacingCar cp = (RacingCar) obj;

        return racingCar.equals(cp.racingCar);
    }
}

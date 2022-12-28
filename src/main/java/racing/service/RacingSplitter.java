package racing.service;

import racing.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingSplitter {
    private final RacingValidator racingValidator;

    public RacingSplitter() {
        racingValidator = new RacingValidator();
    }

    public List<Car> split(String carNames) {
        List<Car> ret = new ArrayList<>();
        for (String carName: carNames.split(",")) {
            carName = carName.trim();
            racingValidator.carNameValidate(carName);
            ret.add(new Car(carName, 1));
        }
        return ret;
    }
}

package racing.service;

import racing.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingSplitter {

    public List<Car> split(String carNames) {
        List<Car> ret = new ArrayList<>();
        for (String carName: carNames.split(",")) {
            carName = carName.trim();
            ret.add(new Car(carName, 1));
        }
        return ret;
    }
}

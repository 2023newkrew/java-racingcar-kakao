package racing.service;

import racing.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarNameSplitter {
    public List<Car> split(String carNames) {
        List<Car> carNameList = new ArrayList<>();
        for (String carName: carNames.split(",")) {
            carName = carName.trim();
            carNameList.add(new Car(carName, 1));
        }
        return carNameList;
    }
}

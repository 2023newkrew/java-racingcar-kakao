package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> cars;

    Racing() {
        cars = new ArrayList<>();
    }

    public void makeCars(List<String> carNames) {
        for (String carName : carNames)
            this.cars.add(new Car(carName));
    }

    public int getCarNo() {
        return cars.size();
    }
}

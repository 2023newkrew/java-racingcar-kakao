package racing.domain;

import java.util.Arrays;

public class Racing {

    public CarList oneCycle(CarList carList) {
        Arrays.stream(carList.getCars()).forEach(Car::carEvent);
        return carList;
    }

}

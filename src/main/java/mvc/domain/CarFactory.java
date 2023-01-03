package mvc.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<Car> createCarsFromNameStr(String carNameStr) {
        String[] carNames = carNameStr.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }
}

package mvc.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class CarConverter {
    public static List<Car> nameStrToCarList(String carNameStr) {
        String[] carNames = carNameStr.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public static String carListToNameStr(List<Car> carList) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.getName()).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

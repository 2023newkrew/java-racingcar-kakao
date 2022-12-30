package mvc.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class CarUtil {
    public static List<Car> generateCarsFromNameStr(String carNameStr) {
        String[] carNames = carNameStr.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public static String extractCarNameStr(List<Car> carList) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.getName()).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

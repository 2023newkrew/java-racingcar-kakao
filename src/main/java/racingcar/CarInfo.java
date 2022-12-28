package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarInfo {

    private String name;
    private int distance;

    public CarInfo(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static List<CarInfo> of(List<Car> cars) {
        return cars.stream()
                .map(car -> new CarInfo(car.getName(), car.getDistance()))
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}

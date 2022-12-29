package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarInfo {

    private String name;
    private int distance;

    public CarInfo(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static CarInfo of(Car car) {
        return new CarInfo(car.getName(), car.getDistance());
    }

    public static List<CarInfo> of(List<Car> cars) {
        return cars.stream()
                .map(CarInfo::of)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}

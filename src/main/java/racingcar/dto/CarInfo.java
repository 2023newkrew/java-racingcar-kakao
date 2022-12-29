package racingcar.dto;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarInfo {

    private String name;
    private int position;

    public CarInfo(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static List<CarInfo> of(List<Car> cars) {
        return cars.stream().map(car -> {
            return new CarInfo(car.getName(), car.getPosition());
        }).collect(Collectors.toList());
    }
}

package racing.dto;

import racing.domain.Car;
import racing.domain.CarName;

public class CarDTO {
    private final CarName name;
    private final int distance;

    public CarDTO(CarName name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public CarName getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public static CarDTO from(Car car) {
        return car.toDTO();
    }
}

package racing.dto;

import racing.domain.Car;

public class CarDTO {
    private final String name;
    private final int distance;

    public CarDTO(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public static CarDTO from(Car car) {
        return car.toDTO();
    }
}

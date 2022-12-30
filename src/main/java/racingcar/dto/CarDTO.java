package racingcar.dto;

import racingcar.domain.Car;

public class CarDTO {

    private final String name;
    private final int position;

    public CarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDTO from(Car car) {
        return new CarDTO(car.getName(), car.getPosition());
    }

    @Override
    public String toString() {
        return this.name + ": " + "-".repeat(Math.max(0, this.position));
    }
}

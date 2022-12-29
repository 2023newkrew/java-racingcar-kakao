package racingcar;

public class CarStatusDto {

    private final String carName;

    private final Integer carPosition;

    public CarStatusDto(String carName, Integer carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public Integer getCarPosition() {
        return carPosition;
    }

    public static CarStatusDto toDto(Car car) {
        return new CarStatusDto(car.getName(), car.getPosition());
    }
}

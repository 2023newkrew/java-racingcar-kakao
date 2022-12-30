package racing.dto;

import racing.domain.Car;
import racing.domain.CarName;
import racing.domain.Position;

public class CarDTO {
    private static final String NULL_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private final CarName name;
    private final Position position;

    public CarDTO(final CarName name, final Position position) {
        if (name == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_EXCEPTION_MESSAGE);
        }
        this.name = name;
        this.position = position;
    }

    public CarName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public static CarDTO of(Car car) {
        return new CarDTO(car.getCarName(), car.getPosition());
    }
}

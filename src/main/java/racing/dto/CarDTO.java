package racing.dto;

import racing.domain.CarName;

public class CarDTO {
    private static final String NULL_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private final CarName name;
    private final int distance;

    public CarDTO(final CarName name, final int distance) {
        if (name == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_EXCEPTION_MESSAGE);
        }
        this.name = name;
        this.distance = distance;
    }

    public CarName getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}

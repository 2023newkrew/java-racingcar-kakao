package racingcar.domain;

import racingcar.dto.CarDTO;

public class Car {

    private int position;
    private final String name;
    private static final int MAX_NAME_LENGTH = 5;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
        this.position = position;
        this.name = name;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.position);
    }

    public int getPosition() {
        return position;
    }
}

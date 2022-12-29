package racingcar;

import java.util.Objects;

public class Car {

    public static final int MIN_CAR_NAME_LENGTH = 1;

    public static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;

    private int position;

    private final Engine engine;

    public static Car from(String name, Engine engine) {
        return Car.from(name, 0, engine);
    }

    public static Car from(String name, int position, Engine engine) {
        name = name.trim();
        checkNameLength(name);
        checkEngineValidation(engine);
        return new Car(name, position, engine);
    }

    private static void checkNameLength(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH) {
            throw new RuntimeException("Car name too short.");
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new RuntimeException("car name too long.");
        }
    }

    private static void checkEngineValidation(Engine engine) {
        if (Objects.isNull(engine)) {
            throw new RuntimeException("Engine is null.");
        }
    }

    private Car(String name, int position, Engine engine) {
        this.name = name;
        this.position = position;
        this.engine = engine;
    }

    public void moveOrStop() {
        if (engine.move()) {
            position++;
        }
    }

    public CarDto getCarInfo() {
        return CarDto.from(name, position);
    }
}

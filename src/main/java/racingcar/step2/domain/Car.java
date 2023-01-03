package racingcar.step2.domain;

import static racingcar.step2.util.MessageConstants.*;
import static racingcar.step2.util.RacingCarConstants.*;
import static racingcar.step2.util.RandomNumberGenerator.generateRandomNumber;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ERR_NAME_DOESNT_EXISTS);
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERR_NAME_OVER_FIVE_LETTERS);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryToMove() {
        move(generateRandomNumber(RANDOM_NUMBER_UPPERBOUND));
    }

    public void move(int condition) {
        if (condition >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public boolean isInPosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return String.format(MSG_TURN_RESULT_FORMAT,
                name, PROGRESS_CHARACTER.repeat(position));
    }
}

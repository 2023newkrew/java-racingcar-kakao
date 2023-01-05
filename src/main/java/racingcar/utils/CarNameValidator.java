package racingcar.utils;

import racingcar.view.Message;

public class CarNameValidator {

    public static void validateRacingCarNames(String[] racingCarNames) {
        for (String racingCarName : racingCarNames) {
            validateRacingCarName(racingCarName);
        }
    }

    public static void validateRacingCarName(String racingCarName) {
        if (racingCarName.isBlank() || racingCarName.length() > 5) {
            throw new IllegalArgumentException(Message.WRONG_NAME.getMessage());
        }
    }}

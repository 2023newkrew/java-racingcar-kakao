package racingcar.utils;

import java.util.Arrays;

public class RacingCarValidator {

    public void validateCarNames(String[] carNames) {
        Arrays.stream(carNames)
                .filter(carName -> carName.length() > 5)
                .findAny()
                .ifPresent(carName -> { throw new RuntimeException(ErrorMessage.CAR_NAME_ERROR_MESSAGE.getMessage()); });
    }

}

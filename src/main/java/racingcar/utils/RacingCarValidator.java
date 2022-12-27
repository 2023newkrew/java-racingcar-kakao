package racingcar.utils;

import java.util.Arrays;

public class RacingCarValidator {

    private static final String CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";

    public void validateCarNames(String[] carNames) {
        Arrays.stream(carNames)
                .filter(carName -> carName.length() > 5)
                .findAny()
                .ifPresent(carName -> { throw new RuntimeException(CAR_NAME_ERROR_MESSAGE); });
    }

}

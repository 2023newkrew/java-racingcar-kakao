package racingcar.utils;

import java.util.Arrays;

public class RacingCarValidator {

    private static final String CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String GAME_ROUND_ERROR_MESSAGE = "시도할 횟수는 0회 이상이어야 합니다.";
    private static final String REMAINING_GAME_ROUND_ERROR_MESSAGE = "게임이 종료되었습니다.";

    public void validateCarNames(String[] carNames) {
        Arrays.stream(carNames)
                .filter(carName -> carName.length() > 5)
                .findAny()
                .ifPresent(carName -> { throw new RuntimeException(CAR_NAME_ERROR_MESSAGE); });
    }

    public void validateGameRound(int gameRound) {
        if (gameRound < 1) {
            throw new RuntimeException(GAME_ROUND_ERROR_MESSAGE);
        }
    }

    public void validateRemainingGameRound(int gameRound) {
        if (gameRound <= 0) {
            throw new RuntimeException(REMAINING_GAME_ROUND_ERROR_MESSAGE);
        }
    }

}

package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RacingGameTest {
    final static int DUMMY_TRIAL_NUMBER = 5;
    final static List<String> DUMMY_CAR_NAMES = Arrays.asList("car1", "car2", "car3");
    RacingGame racingGame = new RacingGame(DUMMY_TRIAL_NUMBER, DUMMY_CAR_NAMES);

    @Test
    void validateTrialUserInput() {
        int input = -1;
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    racingGame.validateTrialUserInput(input);
                });
    }
}

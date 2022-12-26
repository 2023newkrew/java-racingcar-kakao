package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    @Test
    void makeCarsTest() {
        RacingGame racingGame = new RacingGame("car1,car2,car3");
        List<String> expected = new ArrayList<>(List.of("car1", "car2", "car3"));

        for (int i = 0; i < 3; i++) {
            assertThat(racingGame.getCarList().get(i).getName()).isEqualTo(expected.get(i));
        }
    }

    @Test
    void nameLengthTest() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() ->
                        new RacingGame("car1,car2,car3adadadadada")
                );
    }
}
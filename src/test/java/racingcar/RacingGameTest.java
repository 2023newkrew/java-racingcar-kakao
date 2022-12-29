package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RacingGameTest {

    @DisplayName("한 라운드를 진행하고 진행 결과로 RacingCar 리스트를 반환")
    @Test
    void playRound() {
        //given
        List<RacingCar> racingCars = Arrays.asList(
                new RacingCar("car1"),
                new RacingCar("car2"),
                new RacingCar("car3"));
        int rounds = 5;
        RacingGame racingGame = new RacingGame(racingCars, rounds);

        //when
        List<RacingCar> roundResult = racingGame.playRound();

        //then
        Assertions.assertThat(roundResult).hasSize(3);
    }

}

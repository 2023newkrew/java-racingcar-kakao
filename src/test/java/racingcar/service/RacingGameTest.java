package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    RacingCars racingCars;
    int rounds;
    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars(new String[]{"car1", "car2", "car3"});
        rounds = 5;
        racingGame = new RacingGame(racingCars, rounds);
    }

    @DisplayName("한 라운드를 진행하고 진행 결과로 RacingCar 리스트를 반환")
    @Test
    void playRound() {
        //when
        RacingCars roundResult = racingGame.playRound();

        //then
        assertThat(roundResult.getNumOfRacingCars()).isEqualTo(3);
    }

    @DisplayName("입력받은 라운드만큼 라운드를 진행")
    @Test
    void playRound_finish() {
        //when
        int roundCnt = 0;
        while (!racingGame.isFinished()) {
            racingGame.playRound();
            roundCnt++;
        }

        //then
        assertThat(racingGame.isFinished()).isTrue();
        assertThat(roundCnt).isEqualTo(rounds);
    }

    @DisplayName("남은 라운드가 없는데 라운드를 진행하면 예외 발생")
    @Test
    void playRound_throwEx() {
        racingGame = new RacingGame(racingCars, 0);

        assertThatThrownBy(racingGame::playRound).isInstanceOf(IllegalStateException.class);
    }
}

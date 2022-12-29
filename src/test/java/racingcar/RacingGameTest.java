package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(roundResult).hasSize(3);
    }

    @DisplayName("입력받은 라운드만큼 라운드를 진행")
    @Test
    void playRound_finish() {
        //given
        List<RacingCar> racingCars = Arrays.asList(
                new RacingCar("car1"),
                new RacingCar("car2"),
                new RacingCar("car3"));
        int rounds = 5;
        RacingGame racingGame = new RacingGame(racingCars, rounds);

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
        RacingGame racingGame = new RacingGame(new ArrayList<>(), 0);

        assertThatThrownBy(racingGame::playRound).isInstanceOf(IllegalStateException.class);
    }
}

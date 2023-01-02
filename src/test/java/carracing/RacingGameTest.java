package carracing;

import carracing.domain.Car;
import carracing.domain.RacingGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class RacingGameTest {

    @DisplayName("턴 진행 후 턴 카운트가 올라갔는지 & 게임 끝 판정 검사")
    @Test
    void runSingleTurnAndIsFinished() {
        //given
        List<Car> racingPlayers = new ArrayList<>();
        racingPlayers.add(new Car("a"));
        racingPlayers.add(new Car("b"));
        RacingGame racingGame = new RacingGame(racingPlayers, 1);
        //when
        racingGame.runSingleTurn();
        //then
        Assertions.assertThat(racingGame.isFinished()).isTrue();
    }

    @DisplayName("포지션 높은 선수가 우승자로 판정되는지 검사")
    @Test
    void getWinners() {
        //given
        List<Car> racingPlayers = new ArrayList<>();
        Car carA = new Car("a", 3);
        Car carB = new Car("a", 1);
        racingPlayers.add(carA);
        racingPlayers.add(carB);
        RacingGame racingGame = new RacingGame(racingPlayers, 1);
        //when
        //then
        Assertions.assertThat(racingGame.getWinners()).containsExactly(carA);
    }
}
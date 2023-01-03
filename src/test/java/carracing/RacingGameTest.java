package carracing;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.domain.RacingGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class RacingGameTest {

    @DisplayName("턴 진행 후 턴 카운트가 올라갔는지 검사")
    @Test
    void runSingleTurnTest() {
        //given
        List<Car> racingPlayers = new ArrayList<>(
                List.of(new Car("a"), new Car("b"))
        );
        Cars cars = new Cars(racingPlayers);
        RacingGame racingGame = new RacingGame(cars, 10);
        //when
        racingGame.runSingleTurn();
        //then
        Assertions.assertThat(racingGame.getCurrentTurn()).isEqualTo(1);
    }

    @DisplayName("최종 턴 까지 진행 후 게임 종료 판정 검사")
    @Test
    void isFinishedTest() {
        //given
        List<Car> racingPlayers = new ArrayList<>(
                List.of(new Car("a"), new Car("b"))
        );
        Cars cars = new Cars(racingPlayers);
        RacingGame racingGame = new RacingGame(cars, 1);
        //when
        racingGame.runSingleTurn();
        //then
        Assertions.assertThat(racingGame.isFinished()).isTrue();
    }

    @DisplayName("포지션 높은 선수가 우승자로 판정되는지 검사")
    @Test
    void getWinners() {
        //given
        Car carA = new Car("a", 3);
        Car carB = new Car("a", 1);
        List<Car> racingPlayers = new ArrayList<>(
                List.of(carA, carB)
        );
        Cars cars = new Cars(racingPlayers);
        RacingGame racingGame = new RacingGame(cars, 1);
        //when
        //then
        Assertions.assertThat(racingGame.getWinners()).containsExactly(carA);
    }
}
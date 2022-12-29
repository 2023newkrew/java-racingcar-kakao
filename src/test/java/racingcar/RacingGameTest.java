package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    @Test
    @DisplayName("가장 많이 움직인 자동차가 우승한다.")
    void getWinnersTest() {
        List<Car> testCarList = new ArrayList<>();
        testCarList.add(new Car("car1", 5));
        testCarList.add(new Car("car2", 6));
        testCarList.add(new Car("car3", 7));
        RacingGame racingGame = new RacingGame(testCarList, 0);

        assertThat(racingGame.play()).isEqualTo(List.of("car3"));
    }

    @Test
    @DisplayName("공동 우승자가 존재할 수 있다.")
    void coWinnerTest() {
        List<Car> testCarList = new ArrayList<>();
        testCarList.add(new Car("car1", 7));
        testCarList.add(new Car("car2", 6));
        testCarList.add(new Car("car3", 7));
        RacingGame racingGame = new RacingGame(testCarList, 0);

        assertThat(racingGame.play()).isEqualTo(List.of("car1", "car3"));
    }

    @Test
    @DisplayName("모든 자동차가 움직이지 않으면 모두 공동 우승자이다.")
    void zeroWinnerTest() {
        List<Car> testCarList = new ArrayList<>();
        testCarList.add(new Car("car1", 0));
        testCarList.add(new Car("car2", 0));
        testCarList.add(new Car("car3", 0));
        RacingGame racingGame = new RacingGame(testCarList, 0);

        assertThat(racingGame.play()).isEqualTo(List.of("car1", "car2", "car3"));
    }
}
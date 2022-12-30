package racingcar;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.models.Car;
import racingcar.models.RacingGame;
import racingcar.models.RandomNumberGenerator;

public class RacingGameTest {

    List<Car> cars;
    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    public void setUp() {
        car1 = new Car("first", 2);
        car2 = new Car("sec");
        car3 = new Car("third");
        cars = Arrays.asList(car1, car2, car3);
    }

    @Test
    public void testIsEnd() {
        final int COUNT = 5;
        RacingGame racingGame = new RacingGame(cars, COUNT, new RandomNumberGenerator());
        for (int i = 0; i < 5; i++) {
            Assertions.assertThat(racingGame.isEnd()).isFalse();
            racingGame.race();
        }
        Assertions.assertThat(racingGame.isEnd()).isTrue();
    }

    @Test
    public void testInvalidRace() {
        final int COUNT = 0;
        RacingGame racingGame = new RacingGame(cars, COUNT, new RandomNumberGenerator());
        Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(racingGame::race)
                .withMessage("이미 종료된 경주입니다.");
    }

    @Test
    public void testRaceWhenCarsAlwaysMove() {
        final int COUNT = 5;
        cars = Arrays.asList(new Car("first"), new Car("sec"), new Car("third"));
        RacingGame racingGame = new RacingGame(cars, COUNT, () -> 5);
        for (int i = 0; i < COUNT; i++) {
            racingGame.race();
            for (Car car : cars) {
                Assertions.assertThat(car.getPosition()).isEqualTo(i + 2);
            }
        }
    }

    @Test
    public void testRaceWhenCarsAlwaysStop() {
        final int COUNT = 5;
        cars = Arrays.asList(new Car("first"), new Car("sec"), new Car("third"));
        RacingGame racingGame = new RacingGame(cars, COUNT, () -> 0);
        for (int i = 0; i < COUNT; i++) {
            racingGame.race();
            for (Car car : cars) {
                Assertions.assertThat(car.getPosition()).isEqualTo(1);
            }
        }
    }
    @Test
    public void testGetWinnersWhenCarsAlwaysMove() {
        final int COUNT = 5;
        RacingGame racingGame = new RacingGame(cars, COUNT, () -> 5);
        for (int i = 0; i < COUNT; i++) {
            racingGame.race();
        }
        Assertions.assertThat(racingGame.getWinners()).containsExactly(car1);
    }

    @Test
    public void testGetWinnersWhenCarsAlwaysStop() {
        final int COUNT = 5;
        RacingGame racingGame = new RacingGame(cars, COUNT, () -> 0);
        for (int i = 0; i < COUNT; i++) {
            racingGame.race();
        }
        Assertions.assertThat(racingGame.getWinners()).containsExactly(car1);
    }
}

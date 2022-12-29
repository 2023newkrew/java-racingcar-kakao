package racingcar;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.engine.domain.Car;
import racingcar.engine.domain.RacingGame;

public class RacingGameTest {

    List<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = Arrays.asList(new Car("first", 2), new Car("sec"), new Car("third"));
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
        RacingGame racingGame = new RacingGame(cars, COUNT, new NumberGenerator() {
            @Override
            public int generateNumber() {
                return 5;
            }
        });
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
        RacingGame racingGame = new RacingGame(cars, COUNT, new NumberGenerator() {
            @Override
            public int generateNumber() {
                return 0;
            }
        });
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
        RacingGame racingGame = new RacingGame(cars, COUNT, new NumberGenerator() {
            @Override
            public int generateNumber() {
                return 5;
            }
        });
        for (int i = 0; i < COUNT; i++) {
            racingGame.race();
        }
        Assertions.assertThat(racingGame.getWinners()).containsExactly("first");
    }

    @Test
    public void testGetWinnersWhenCarsAlwaysStop() {
        final int COUNT = 5;
        RacingGame racingGame = new RacingGame(cars, COUNT, new NumberGenerator() {
            @Override
            public int generateNumber() {
                return 0;
            }
        });
        for (int i = 0; i < COUNT; i++) {
            racingGame.race();
        }
        Assertions.assertThat(racingGame.getWinners()).containsExactly("first");
    }
}

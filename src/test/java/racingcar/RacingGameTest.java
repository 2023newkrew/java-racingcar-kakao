package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.models.Car;
import racingcar.models.RacingGame;
import racingcar.models.RandomNumberGenerator;

public class RacingGameTest {

    List<Car> cars;
    Car car1;
    Car car2;
    Car car3;

    @Nested
    @DisplayName("Racing Game 종료 테스트")
    public class testIsEndMethod {

        @BeforeEach
        public void setUp() {
            car1 = new Car("first", 2);
            car2 = new Car("sec");
            car3 = new Car("third");
            cars = Arrays.asList(car1, car2, car3);
        }
        @Test
        @DisplayName("목표 Count를 채우지 않았다면 종료 상태가 아니다.")
        public void testIsNotEnd() {
            final int COUNT = 1;
            RacingGame racingGame = new RacingGame(cars, COUNT, new RandomNumberGenerator());
            Assertions.assertThat(racingGame.isEnd()).isFalse();
        }

        @Test
        @DisplayName("목표 Count를 채웠다면 종료 상태이다.")
        public void testIsEnd() {
            final int COUNT = 0;
            RacingGame racingGame = new RacingGame(cars, COUNT, new RandomNumberGenerator());
            Assertions.assertThat(racingGame.isEnd()).isTrue();
        }
    }

    @Nested
    @DisplayName("Racing Game 레이스 테스트")
    public class testRaceMethod {

        @BeforeEach
        public void setUp() {
            car1 = new Car("first");
            car2 = new Car("sec");
            car3 = new Car("third");
            cars = Arrays.asList(car1, car2, car3);
        }
        @Test
        @DisplayName("종료된 경주에서는 Race 할 수 없다.")
        public void testInvalidRace() {
            final int COUNT = 0;
            RacingGame racingGame = new RacingGame(cars, COUNT, new RandomNumberGenerator());
            Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(racingGame::race)
                    .withMessage("이미 종료된 경주입니다.");
        }

        @Test
        @DisplayName("Race 시 4 이상의 숫자가 들어오면 Car의 Position은 1씩 증가한다.")
        public void testRaceWhenCarsAlwaysMove() {
            final int COUNT = 5;
            RacingGame racingGame = new RacingGame(cars, COUNT, () -> {
                Random random = new Random();
                return random.nextInt(6) + 4;
            });
            for (int i = 0; i < COUNT; i++) {
                racingGame.race();
                for (Car car : cars) {
                    Assertions.assertThat(car.getPosition()).isEqualTo(i + 2);
                }
            }
        }

        @Test
        @DisplayName("Race 시 4 미만의 숫자가 들어오면 Car의 Position은 변화가 없다.")
        public void testRaceWhenCarsAlwaysStop() {
            final int COUNT = 5;
            RacingGame racingGame = new RacingGame(cars, COUNT, () -> {
                Random random = new Random();
                return random.nextInt(4);
            });
            for (int i = 0; i < COUNT; i++) {
                racingGame.race();
                for (Car car : cars) {
                    Assertions.assertThat(car.getPosition()).isEqualTo(1);
                }
            }
        }
    }
}

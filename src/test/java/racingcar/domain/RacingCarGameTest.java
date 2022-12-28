package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.AppConfig;
import racingcar.AppConfigImpl;
import racingcar.generator.RandomNumberGenerator;

public class RacingCarGameTest {
    static AppConfig appConfig;
    static Field randomNumberGenerator;
    static RacingCarGame racingCarGame;

    /**
     * RandomNumberGeneratorTest를 위해 구현한 FakeRandomNumberGenerator
     * generator 실행 횟수가 짝수 일 경우 4 그외 3
     */
    static class FakeRandomNumberGenerator implements RandomNumberGenerator {
        int seed = 0;

        @Override
        public int generator() {
            seed++;
            if (seed % 2 == 0) {
                return 4;
            }
            return 3;
        }
    }

    @BeforeAll
    static void setUp() throws NoSuchFieldException, IllegalAccessException {
        appConfig = new AppConfigImpl();
        randomNumberGenerator = AppConfigImpl.class.getDeclaredField("randomNumberGenerator");
        randomNumberGenerator.setAccessible(true);
    }

    @BeforeEach
    void init() throws IllegalAccessException {
        randomNumberGenerator.set(appConfig, new FakeRandomNumberGenerator());
        racingCarGame = new RacingCarGameImpl(appConfig);
    }


    @Test
    public void runTest() throws NoSuchFieldException, IllegalAccessException {
        Car car1 = new RacingCar("pobi");
        Car car2 = new RacingCar("crong");
        Car car3 = new RacingCar("honux");

        racingCarGame.add(car1, car2, car3);
        racingCarGame.run(5);

        Field cars = RacingCarGameImpl.class.getDeclaredField("cars");
        cars.setAccessible(true);
        ArrayList<Car> racingCars = (ArrayList<Car>) cars.get(racingCarGame);

        assertThat(racingCars.get(0)
                .getDistance()).isEqualTo(2);
        assertThat(racingCars.get(1)
                .getDistance()).isEqualTo(3);
        assertThat(racingCars.get(2)
                .getDistance()).isEqualTo(2);
    }

    @Test
    public void getSingleWinner() {
        Car car1 = new RacingCar("pobi");
        Car car2 = new RacingCar("crong");
        Car car3 = new RacingCar("honux");

        racingCarGame.add(car1, car2, car3);
        racingCarGame.run(5);

        assertThat(racingCarGame.getWinner()
                .size()).isEqualTo(1);
        assertThat(racingCarGame.getWinner()
                .get(0)).isEqualTo(car2);
    }

    @Test
    public void getMultiWinner() {
        Car car1 = new RacingCar("pobi");
        Car car2 = new RacingCar("crong");
        Car car3 = new RacingCar("honux");
        Car car4 = new RacingCar("russell");

        racingCarGame.add(car1, car2, car3, car4);
        racingCarGame.run(5);

        Assertions.assertThat(racingCarGame.getWinner()
                        .size())
                .isEqualTo(2);
        Assertions.assertThat(racingCarGame.getWinner())
                .containsExactly(car2, car4);
    }

    @Test
    public void getCarResultsTest() {
        Car car1 = new RacingCar("pobi");
        Car car2 = new RacingCar("crong");

        racingCarGame.add(car1, car2);
        racingCarGame.run(5);

        assertThat(racingCarGame.getCarResults()).containsExactly("pobi : ", "crong : -----");
    }
}

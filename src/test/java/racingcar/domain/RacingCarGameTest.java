package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;

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
    static void setUp() throws NoSuchFieldException {
        appConfig = new AppConfigImpl();
        randomNumberGenerator = AppConfigImpl.class.getDeclaredField("randomNumberGenerator");
        randomNumberGenerator.setAccessible(true);
    }

    @BeforeEach
    void init() throws IllegalAccessException {
        randomNumberGenerator.set(appConfig, new FakeRandomNumberGenerator());
    }

    @Test
    void createCarsWithCarNamesTest() {
        String[] carNames = new String[]{"pobi", "crong"};
        racingCarGame = new RacingCarGameImpl(appConfig, carNames);

        assertThat(racingCarGame.getCars()
                .getCars()
                .size()).isEqualTo(2);

        assertThat(racingCarGame.getCars()
                .getCars()
                .get(0)
                .getName()).isEqualTo("pobi");
    }


    @Test
    public void runTest(){
        String[] carNames = new String[]{"pobi", "crong","honux"};
        racingCarGame = new RacingCarGameImpl(appConfig, carNames);

        racingCarGame.race(5);

        List<Car> resultCars = racingCarGame.getCars()
                .getCars();

        assertThat(resultCars.get(0)
                .getPosition()).isEqualTo(2);
        assertThat(resultCars.get(1)
                .getPosition()).isEqualTo(3);
        assertThat(resultCars.get(2)
                .getPosition()).isEqualTo(2);

    }
//    @Test
//    public void runTest() throws NoSuchFieldException, IllegalAccessException {
//        Car car1 = CarFactory.createCar("pobi");
//        Car car2 = CarFactory.createCar("crong");
//        Car car3 = CarFactory.createCar("honux");
//
//        racingCarGame.add(car1, car2, car3);
//        racingCarGame.run(5);
//
//        Field cars = RacingCarGameImpl.class.getDeclaredField("cars");
//        cars.setAccessible(true);
//        ArrayList<Car> racingCars = (ArrayList<Car>) cars.get(racingCarGame);
//
//        assertThat(racingCars.get(0)
//                .getPosition()).isEqualTo(2);
//        assertThat(racingCars.get(1)
//                .getPosition()).isEqualTo(3);
//        assertThat(racingCars.get(2)
//                .getPosition()).isEqualTo(2);
//    }

}

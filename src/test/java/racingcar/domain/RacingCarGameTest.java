package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.AppConfig;
import racingcar.AppConfigImpl;
import racingcar.generator.RandomNumberGenerator;

public class RacingCarGameTest {

    @Test
    public void runTest() throws NoSuchFieldException, IllegalAccessException {
        AppConfig appConfig = new AppConfigImpl();
        Field randomNumberGenerator = AppConfigImpl.class.getDeclaredField("randomNumberGenerator");
        randomNumberGenerator.setAccessible(true);
        randomNumberGenerator.set(appConfig, new FakeRandomNumberGenerator());
        RacingCarGame racingCarGame = new RacingCarGameImpl(appConfig);

        racingCarGame.add("pobi");
        racingCarGame.add("crong");
        racingCarGame.add("honux");

        racingCarGame.run(5);

        Field cars = RacingCarGameImpl.class.getDeclaredField("cars");
        cars.setAccessible(true);
        ArrayList<Car> racingCars = (ArrayList<Car>) cars.get(racingCarGame);
        assertThat(racingCars.get(0).getDistance()).isEqualTo(2);
        assertThat(racingCars.get(1).getDistance()).isEqualTo(2);
        assertThat(racingCars.get(2).getDistance()).isEqualTo(3);
    }

    @Test
    public void getSingleWinner() throws NoSuchFieldException, IllegalAccessException {
        AppConfig appConfig = new AppConfigImpl();
        Field randomNumberGenerator = AppConfigImpl.class.getDeclaredField("randomNumberGenerator");
        randomNumberGenerator.setAccessible(true);
        randomNumberGenerator.set(appConfig, new FakeRandomNumberGenerator());
        RacingCarGame racingCarGame = new RacingCarGameImpl(appConfig);

        Car car1 = new RacingCar("pobi");
        Car car2 = new RacingCar("crong");
        Car car3 = new RacingCar("honux");

        racingCarGame.add(car1, car2, car3);
        racingCarGame.run(5);

        assertThat(racingCarGame.getWinner().get(0)).isEqualTo(car3);
    }

    static class FakeRandomNumberGenerator implements RandomNumberGenerator{
        int seed = 0;
        @Override
        public int generator() {
            int number = seed%10;
            seed++;
            return number;
        }
    }



}

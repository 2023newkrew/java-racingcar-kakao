package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.generator.RandomNumberGenerator;

public class RacingCarGameTest {
    static RacingCarGame racingCarGame;

    /**
     * RandomNumberGeneratorTest를 위해 구현한 FakeRandomNumberGenerator generator 실행 횟수가 짝수 일 경우 4 그외 3
     */
    static class FakeRandomNumberGenerator implements RandomNumberGenerator {
        int seed = 0;

        @Override
        public int generate() {
            seed++;
            if (seed % 2 == 0) {
                return 4;
            }
            return 3;
        }
    }

    void run(int times) {
        for (int i = 0; i < times; i++) {
            racingCarGame.run();
        }
    }

    @BeforeEach
    void init() {
        racingCarGame = new RacingCarGameImpl(new FakeRandomNumberGenerator());
    }


    @Test
    @DisplayName("run을 실행하면 자동차들이 FakeRandomNumberGenerator에 의해 이동한다.")
    public void runTest() throws NoSuchFieldException, IllegalAccessException {
        racingCarGame.add(Set.of("pobi","crong","honux"));
        run(5);
        Field cars = RacingCarGameImpl.class.getDeclaredField("cars");
        cars.setAccessible(true);
        ArrayList<Car> racingCars = (ArrayList<Car>) cars.get(racingCarGame);
        assertThat(racingCars.get(0).getDistance()).isEqualTo(2);
        assertThat(racingCars.get(1).getDistance()).isEqualTo(3);
        assertThat(racingCars.get(2).getDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("승자가 1명일 때 리스트의 길이는 1이고, 해당 객체를 반환해야 한다.")
    public void getSingleWinner() {
        Car car1 = new RacingCar("pobi");
        Car car2 = new RacingCar("crong");
        Car car3 = new RacingCar("honux");
        racingCarGame.add(car1, car2, car3);
        run(5);
        assertThat(racingCarGame.getWinner().size()).isEqualTo(1);
        assertThat(racingCarGame.getWinner().get(0)).isEqualTo(car2);
    }

    @Test
    @DisplayName("승자가 여러명일 때 리스트의 길이는 해당 승자수와 같고, 해당 객체들을 입력된 순서대로 반환해야 한다.")
    public void getMultiWinner() {
        Car car1 = new RacingCar("pobi");
        Car car2 = new RacingCar("crong");
        Car car3 = new RacingCar("honux");
        Car car4 = new RacingCar("soony");
        racingCarGame.add(car1, car2, car3, car4);
        run(5);
        Assertions.assertThat(racingCarGame.getWinner().size()).isEqualTo(2);
        Assertions.assertThat(racingCarGame.getWinner()).containsExactly(car2, car4);
    }

    @Test
    @DisplayName("진행한 run에 따른 적절한 toString 결과를 반환해야 한다.")
    public void getCarResultsTest() {
        Car car1 = new RacingCar("pobi");
        Car car2 = new RacingCar("crong");
        racingCarGame.add(car1, car2);
        run(5);

        assertThat(racingCarGame.getCarResults()).containsExactly("pobi : ", "crong : -----");
    }
}

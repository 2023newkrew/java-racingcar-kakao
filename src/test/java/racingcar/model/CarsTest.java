package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CarsTest {

    Cars cars;
    private final static String CAR_DUMMY_STRING = "dummy";

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList("car1", "car2", "car3"));
    }

    @Test
    void checkDuplicatedCarName() {
        List<String> input = Arrays.asList("car1", "car1", "car3");
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    cars.checkDuplicatedCarName(input);
                });
    }

    @Test
    void selectWinners() {
        Car car1 = cars.getCarList().get(0);
        Car car2 = cars.getCarList().get(1);
        car1.move(5);
        car2.move(5);
        List<Car> winner = cars.getWinners();
        Assertions.assertThat(winner)
                .containsOnly(car1, car2);
    }
}

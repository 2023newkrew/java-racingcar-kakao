package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CarsTest {

    Cars cars = new Cars(Arrays.asList("car1", "car2", "car3"));
    private final static String CAR_DUMMY_STRING = "dummy";

    @Test
    void addAll() {

    }

    @Test
    void selectWinners() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.move(5);
        car2.move(5);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        List<Car> winner = cars.getWinners();
        Assertions.assertThat(winner)
                .containsOnly(car1, car2);
    }
}

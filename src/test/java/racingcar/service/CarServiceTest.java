package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

public class CarServiceTest {

    private final static String CAR_DUMMY_STRING = "dummy";

    @Test
    void selectWinners() {
        CarService carService = new CarService();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.move(5);
        car2.move(5);
        carService.add(car1);
        carService.add(car2);
        carService.add(car3);
        List<Car> winner = carService.getWinners();
        Assertions.assertThat(winner)
                .containsOnly(car1, car2);
    }
}

package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarContainer;
import racingcar.domain.model.Car;

import java.util.List;

public class CarContainerTest {

    @Test
    void duplicatedNameException() {
        CarContainer carContainer = new CarContainer();
        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    carContainer.add(new Car("lion"));
                    carContainer.add(new Car("lion"));
                });
    }

    @Test
    void selectWinners() {
        CarContainer carContainer = new CarContainer();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.move(5);
        car2.move(5);
        carContainer.add(car1);
        carContainer.add(car2);
        carContainer.add(car3);
        List<Car> winner = carContainer.selectWinners();
        Assertions.assertThat(winner)
                .containsOnly(car1, car2);
    }
}

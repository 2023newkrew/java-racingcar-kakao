package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarListManagerTest {

    @Test
    void duplicatedNameException() {
        CarListManager carListManager = new CarListManager();
        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    carListManager.add(new Car("lion"));
                    carListManager.add(new Car("lion"));
                });
    }

    @Test
    void selectWinners() {
        CarListManager carListManager = new CarListManager();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.move(5);
        car2.move(5);
        carListManager.add(car1);
        carListManager.add(car2);
        carListManager.add(car3);
        List<Car> winner = carListManager.selectWinners();
        Assertions.assertThat(winner)
                .containsOnly(car1, car2);
    }
}

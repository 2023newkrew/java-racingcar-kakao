package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarListTest {

    @Test
    void duplicatedNameException() {
        CarList carList = new CarList();
        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    carList.add(new Car("lion"));
                    carList.add(new Car("lion"));
                });
    }

    @Test
    void selectWinners() {
        CarList carList = new CarList();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.move(5);
        car2.move(5);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        List<Car> winner = carList.selectWinners();
        Assertions.assertThat(winner)
                .containsOnly(car1, car2);
    }
}

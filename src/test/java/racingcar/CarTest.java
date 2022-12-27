package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void moveCar() {
        Car car = new Car("dummy");
        int prevPosition = car.getPosition();
        car.move();
        Assertions.assertThat(car.getPosition())
                .isEqualTo(prevPosition + 1);
    }

    @Test
    void over5WordsName() {
        String name = "abcdef";
        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    Car car = new Car(name);
                });
    }
}

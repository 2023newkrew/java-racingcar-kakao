package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingCar;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new RacingCar("test", 1);
    }

    @Test
    @DisplayName("Car가 이동하면 위치가 1 증가한다.")
    void moveSuccess() {
        car.move(() -> true);
        Assertions.assertThat(car).isEqualTo(new RacingCar("test", 2));
    }

    @Test
    @DisplayName("Car가 이동하지 않으면 위치가 그대로다.")
    void moveFail() {
        car.move(() -> false);
        Assertions.assertThat(car).isEqualTo(new RacingCar("test", 1));
    }
}

package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void forward() {
        Car car = new Car("aa");

        CarDTO beforeMoveCarDto = car.toDTO();
        car.move(() -> CarAction.FORWARD);
        CarDTO afterMoveCarDto = car.toDTO();

        assertThat(afterMoveCarDto.getPosition()).isEqualTo(beforeMoveCarDto.getPosition() + 1);
    }

    @Test
    void stay() {
        Car car = new Car("aa");

        CarDTO beforeMoveCarDto = car.toDTO();
        car.move(() -> CarAction.STAY);
        CarDTO afterMoveCarDto = car.toDTO();

        assertThat(afterMoveCarDto.getPosition()).isEqualTo(beforeMoveCarDto.getPosition());
    }
}

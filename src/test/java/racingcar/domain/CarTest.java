package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {

    @Test
    void create_car_test() {
        Car car = new Car("joel");

        int position = car.getPosition();
        String carName = car.getCarName();

        assertThat(position).isEqualTo(0);
        assertThat(carName).isEqualTo("joel");
    }

    @Test
    void validate_car_name_test() {
        String invalidCarName = "redjoelredjoel";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(invalidCarName))
                .withMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void movement_test() {
        Car car = new Car("red");

        int position1 = car.getPosition();
        assertThat(position1).isEqualTo(0);

        car.move();
        int position2 = car.getPosition();
        assertThat(position2).isEqualTo(1);

        car.stay();
        int position3 = car.getPosition();
        assertThat(position3).isEqualTo(1);

        car.move();
        int position4 = car.getPosition();
        assertThat(position4).isEqualTo(2);

        car.stay();
        car.stay();
        int position5 = car.getPosition();
        assertThat(position5).isEqualTo(2);

        car.move();
        car.move();
        int position6 = car.getPosition();
        assertThat(position6).isEqualTo(4);
    }
}

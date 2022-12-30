package mvc.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("랜덤값이 4 이상일 때 자동자 전진")
    void move() {
        Car car = new Car("name") {
            @Override
            protected int moveVal() {
                return 4;
            }
        };
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤값이 3 이하일 때 자동자 멈춤")
    void stop() {
        Car car = new Car("name") {
            @Override
            protected int moveVal() {
                return 3;
            }
        };
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
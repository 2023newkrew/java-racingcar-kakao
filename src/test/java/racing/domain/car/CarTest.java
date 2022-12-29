package racing.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.Car;

import static org.assertj.core.api.Assertions.*;


public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    @DisplayName("이동한 후에는 포지션이 1 증가한다.")
    public void move() {
        int expected = car.getPosition() + 1;
        int actual;

        car.move();
        actual = car.getPosition();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("같은 포지션의 자동차를 비교했을 때 true를 리턴한다.")
    public void isEqualPosition() {
        Car newCar = new Car("new");
        assertThat(car.isEqualPosition(newCar)).isEqualTo(true);
    }

    @Test
    @DisplayName("다른 포지션의 자동차를 비교했을 때 false를 리턴한다.")
    public void isNotEqualPosition() {
        Car newCar = new Car("new", 1);
        assertThat(car.isEqualPosition(newCar)).isEqualTo(false);
    }
}

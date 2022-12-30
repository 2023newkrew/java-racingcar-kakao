package racing.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.strategy.strategy.AlwaysMovableStrategy;
import racing.strategy.strategy.AlwaysNotMovableStrategy;

import static org.assertj.core.api.Assertions.*;


public class CarTest {

    @Test
    @DisplayName("이동한 후에는 포지션이 1 증가한다.")
    public void move() {
        Car car = new Car.Builder("car")
                    .movableStrategy(new AlwaysMovableStrategy())
                    .build();
        int expected = car.getPosition() + 1;
        int actual;

        car.movePositionIfMovable();
        actual = car.getPosition();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동에 실패하면 위치가 그대로 유지된다.")
    public void notMove() {
        Car car = new Car.Builder("car")
                .movableStrategy(new AlwaysNotMovableStrategy())
                .build();
        int expected = car.getPosition();
        int actual;

        car.movePositionIfMovable();
        actual = car.getPosition();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("같은 포지션의 자동차를 비교했을 때 true를 리턴한다.")
    public void isEqualPosition() {
        Car car = new Car.Builder("car")
                    .build();

        assertThat(car.isEqualPosition(car)).isEqualTo(true);
    }

    @Test
    @DisplayName("다른 포지션의 자동차를 비교했을 때 false를 리턴한다.")
    public void isNotEqualPosition() {
        Car car1 = new Car.Builder("car1")
                    .position(1)
                    .build();
        Car car2 = new Car.Builder("car2")
                    .position(2)
                    .build();

        assertThat(car1.isEqualPosition(car2)).isEqualTo(false);
    }
}

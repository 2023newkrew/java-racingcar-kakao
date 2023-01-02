package racing.domain.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.strategy.interfaces.MovableStrategy;

import static org.assertj.core.api.Assertions.*;


public class CarTest {
    @ParameterizedTest
    @DisplayName("이동한 후에는 포지션이 1 증가한다.")
    @CsvSource(value = {"1:2", "2:3", "3:4", "4:5"}, delimiter = ':')
    public void move(int before, int after) {
        Car car1 = new Car.Builder("car1")
                .position(before)
                .movableStrategy(new MovableStrategy() {
                    @Override
                    public boolean isMovable() {
                        return true;
                    }
                })
                .build();

        Car car2 = new Car.Builder("car2")
                .position(after)
                .build();

        car1.movePositionIfMovable();

        assertThat(car1.isEqualPosition(car2)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("이동에 실패하면 위치가 그대로 유지된다.")
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4"}, delimiter = ':')
    public void notMove(int before, int after) {
        Car car1 = new Car.Builder("car")
                .position(before)
                .movableStrategy(new MovableStrategy() {
                    @Override
                    public boolean isMovable() {
                        return false;
                    }
                })
                .build();

        Car car2 = new Car.Builder("car2")
                .position(after)
                .build();

        car1.movePositionIfMovable();

        assertThat(car1.isEqualPosition(car2)).isEqualTo(true);
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

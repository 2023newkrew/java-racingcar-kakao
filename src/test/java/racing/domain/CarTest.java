package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car("car1");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이름은_한글자_이상이여야_한다(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(doubles = {0.1, 3.9, 2.2, 3.999})
    @ParameterizedTest
    void 자동차가_움직이지_않는다(double number) {
        assertThat(car.move(number)).isEqualTo(false);
    }

    @ValueSource(doubles = {4.0, 5.0, 8.999})
    @ParameterizedTest
    void 자동차가_움직인다(double number) {
        assertThat(car.move(number)).isEqualTo(true);
    }

    @Test
    void 두대의_자동차로_움직이는_조건이_잘_동작하는지_테스트(){
        Car opponent = new Car("car2");
        assertAll(
                () -> assertTrue(opponent.equalsDistance(car.getDistance())),

                () -> {
                    opponent.move(5);
                    car.move(3);
                    assertTrue(opponent.getDistance() > car.getDistance());
                }
        );
    }
}

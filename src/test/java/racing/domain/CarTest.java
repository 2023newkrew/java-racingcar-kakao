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

    @Test
    void 이름은_5글자_이하여야_한다() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf((IllegalArgumentException.class));
    }

    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void 숫자가_4보다_작으면_움직이지_않는다(Integer number) {
        car.move(number);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void 숫자가_4_이상이면_움직인다(Integer number) {
        car.move(number);
        assertThat(car.getDistance()).isEqualTo(1);
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

package racingcar.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step2.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("자동차는 5자 이하의 이름을 가진다.")
    void createCarTest() {
        assertThatCode(() -> new Car("jade"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("5자 초과의 이름의 자동차를 생성할 경우 예외가 발생한다.")
    void createCar_Exceed5ExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("jadexyz"))
                .withMessage("자동차의 이름은 5자를 넘을 수 없습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차의 이름이 없는 경우 예외가 발생한다.")
    void createCar_NullOrBlankExceptionTest(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name))
                .withMessage("자동차는 이름이 존재해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("자동차는 3 이하의 수인 경우 정지한다.")
    void stopTest(int condition) {
        Car car = new Car("jade");

        car.move(condition);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("자동차는 4 이상의 수인 경우 전진한다.")
    void moveTest(int condition) {
        Car car = new Car("jade");

        car.move(condition);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
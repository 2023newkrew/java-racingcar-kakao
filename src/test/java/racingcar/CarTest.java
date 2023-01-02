package racingcar;

import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.models.Car;

public class CarTest {

    private final Car car = new Car("pobi");

    private final Random random = new Random();

    @Nested
    @DisplayName("자동차 생성 테스트")
    public class CreateCar {
        @ParameterizedTest
        @DisplayName("자동차를 생성할 수 있다.")
        @ValueSource(strings = {"pobi", "jaws", "jayde"})
        public void testCreateCar(String input) {
            Car newCar = new Car(input);
            Assertions.assertThat(newCar.getCurrentPosition()).isEqualTo(input + " : -");
        }

        @ParameterizedTest
        @DisplayName("잘못된 이름으로 자동차를 생성하면 예외가 발생한다.")
        @ValueSource(strings = {"   ", "jayden"})
        public void testCreateCarUsingInvalidName(String input) {
            Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
                new Car(input);
            }).withMessage("잘못된 자동차 이름입니다.");
        }
    }

    @Nested
    @DisplayName("자동차 이동 테스트")
    public class MoveCar {
        @Test
        @DisplayName("4보다 크거나 같은 숫자가 들어오면 자동차는 움직인다.")
        public void testCarWithPowerGreaterOrEqualThan4() {
            car.moveWithPower(4 + random.nextInt(6));
            Assertions.assertThat(car.getCurrentPosition()).isEqualTo("pobi : --");
        }

        @Test
        @DisplayName("4보다 작은 숫자가 들어오면 자동차는 움직이지 않는다.")
        public void testCarWithPowerLessThan4() {
            car.moveWithPower(random.nextInt(4));
            Assertions.assertThat(car.getCurrentPosition()).isEqualTo("pobi : -");
        }
    }
}

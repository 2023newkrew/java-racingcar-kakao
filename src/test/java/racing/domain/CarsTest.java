package racing.domain;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.Cars;
import racing.util.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static racing.util.RandomNumberGenerator.*;
public class CarsTest {

    private Cars cars;

    @BeforeEach
    public void setUp() {
        cars = new Cars();
    }

    @Test
    @Deprecated
    @Disabled
    @DisplayName("랜덤 숫자가 4 이상이면 이동할 수 있다.")
    public void isMove() {
        assertThat(cars.isMovable()).isEqualTo(true);
        assertThat(cars.isMovable()).isEqualTo(true);
    }

    @Test
    @Deprecated
    @Disabled
    @DisplayName("랜덤 숫자가 4 미만이면 이동할 수 없다.")
    public void isStop() {
        assertThat(cars.isMovable()).isEqualTo(false);
        assertThat(cars.isMovable()).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"marcus", "noah.u"})
    @DisplayName("자동차 이름은 5글자 이하이여야 한다.")
    public void carNameLengthOutOfRange(String input) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                new Car(input);
            });
    }

}

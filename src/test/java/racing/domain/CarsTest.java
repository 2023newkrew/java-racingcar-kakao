package racing.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
public class CarsTest {
    private Cars cars;
    @BeforeEach
    public void setUp() {
        cars = new Cars();
    }

    @ParameterizedTest
    @DisplayName("숫자가 4 이상이면 이동할 수 있다.")
    @CsvSource(value = {"4:true", "9:true"}, delimiter = ':')
    public void isMove(int input, boolean expected) {
        assertThat(cars.isMovable(input)).isEqualTo(expected);
        assertThat(cars.isMovable(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자가 4 미만이면 이동할 수 없다.")
    @CsvSource(value = {"0:false", "3:false"}, delimiter = ':')
    public void isStop(int input, boolean expected) {
        assertThat(cars.isMovable(input)).isEqualTo(expected);
        assertThat(cars.isMovable(input)).isEqualTo(expected);
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

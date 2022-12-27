package racing.domain;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
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
    public void isMove() {
        assertThat(cars.isMovable()).isEqualTo(true);
        assertThat(cars.isMovable()).isEqualTo(true);
    }

    @Test
    @Deprecated
    @Disabled
    public void isStop() {
        assertThat(cars.isMovable()).isEqualTo(false);
        assertThat(cars.isMovable()).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"marcus", "noah.u"})
    public void carNameLengthOutOfRange(String input) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                new Car(input);
            });
    }

}

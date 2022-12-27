package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void car(String name) {
        Car car = new Car(name);
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void carException(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Car(name));
    }
}

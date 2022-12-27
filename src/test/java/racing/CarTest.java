package racing;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"1234", "ABCD"})
    void toString(String name) {
        Car car = new Car(name);
        assertThat(car.toString()).isEqualTo(String.format("%s : -", name));
    }

    @ParameterizedTest
    @MethodSource("getMoveData")
    void move(String name, int move, String expected) {
        Car car = new Car(name);
        for (int i = 0; i < move; i++) {
            car.move();
        }
        assertThat(car.toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> getMoveData() {
        return Stream.of(
                Arguments.of("ABCD", 2, "ABCD : ---"),
                Arguments.of("ABCD", 3, "ABCD : ----"),
                Arguments.of("ABCD", 4, "ABCD : -----")
        );
    }
}

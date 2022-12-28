package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("getComparableData")
    void compare(String base, int baseMove, String compare, int compareMove, int expected) {
        Car baseCar = new Car(base);
        Car compareCar = new Car(compare);

        for (int i = 0; i < baseMove; i++) {
            baseCar.move();
        }

        for (int i = 0; i < compareMove; i++) {
            compareCar.move();
        }

        assertThat(baseCar.compareTo(compareCar)).isEqualTo(expected);
    }

    private static Stream<Arguments> getComparableData() {
        return Stream.of(
                Arguments.of("CAR1", 2, "CAR2", 2, 0),
                Arguments.of("CAR1", 2, "CAR2", 3, -1),
                Arguments.of("CAR1", 3, "CAR2", 2, 1)
        );
    }
}

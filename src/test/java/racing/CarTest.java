package racing;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;

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
    @MethodSource("getComparableData")
    void compare(String base, int baseMove, String compare, int compareMove, int expected) {
        Car baseCar = new Car(base);
        Car compareCar = new Car(compare);

        for (int i = 0; i < baseMove; i++) {
            baseCar.moveByCondition(4);
        }

        for (int i = 0; i < compareMove; i++) {
            compareCar.moveByCondition(4);
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

    @ParameterizedTest
    @MethodSource("getRandomMoveData")
    void randomMove(String name, int random, String expected) {
        Car car = new Car(name);
        car.moveByCondition(random);
        assertThat(car.toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> getRandomMoveData() {
        return Stream.of(
                Arguments.of("ABCD", 1, "ABCD : -"),
                Arguments.of("ABCD", 3, "ABCD : -"),
                Arguments.of("ABCD", 4, "ABCD : --"),
                Arguments.of("ABCD", 5, "ABCD : --")
        );
    }
}

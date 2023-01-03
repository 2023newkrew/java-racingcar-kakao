package racing;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void createCar(String name) {
        assertThatCode(() -> new Car(name)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void createCarException(String name) {
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
            baseCar.moveByCondition(() -> true);
        }

        for (int i = 0; i < compareMove; i++) {
            compareCar.moveByCondition(() -> true);
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
    @MethodSource("getMoveByConditionData")
    void moveByCondition(String name, boolean condition, String expected) {
        Car car = new Car(name);
        car.moveByCondition(() -> condition);
        assertThat(car.toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> getMoveByConditionData() {
        return Stream.of(
                Arguments.of("ABCD", false, "ABCD : -"),
                Arguments.of("ABCD", true, "ABCD : --")
        );
    }
}

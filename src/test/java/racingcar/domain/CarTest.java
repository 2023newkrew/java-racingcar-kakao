package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.service.dto.CarResponse;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차가 전진한다.")
    @ParameterizedTest
    @MethodSource("provideMovableTrue")
    void moveIfRandomNumberIsGreaterThanEqualFour(String carName, Movable movable, int movingCount) {
        Car car = new Car(carName);

        for (int i = 0; i < movingCount; i++) {
            car.move(movable);
        }

        CarResponse carResponse = car.toResponse();
        assertThat(carResponse.getPosition()).isEqualTo(movingCount);
    }

    @DisplayName("자동차가 정지한다.")
    @ParameterizedTest
    @MethodSource("provideMovableFalse")
    void stopIfRandomNumberIsLessThanEqualThree(String carName, Movable movable, int movingCount) {
        Car car = new Car(carName);

        for (int i = 0; i < movingCount; i++) {
            car.move(movable);
        }

        CarResponse carResponse = car.toResponse();
        assertThat(carResponse.getPosition()).isZero();
    }

    private static Stream<Arguments> provideMovableTrue() {
        return Stream.of(
                Arguments.of("car1", (Movable)() -> true, 1),
                Arguments.of("car2", (Movable)() -> true, 3)
        );
    }

    private static Stream<Arguments> provideMovableFalse() {
        return Stream.of(
                Arguments.of("car1", (Movable)() -> false, 1),
                Arguments.of("car2", (Movable)() -> false, 3)
        );
    }

}

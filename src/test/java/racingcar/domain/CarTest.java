package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.CarDto;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차는 random값이 4 이상일 경우 전진한다.")
    @ParameterizedTest
    @MethodSource("provideMovingCountWithMovableNumber")
    void moveIfRandomNumberIsGreaterThanEqualFour(String carName, int movingCount, int randomNumber) {
        Car car = new Car(carName);
        int initialPosition = 1;

        for (int i = 0; i < movingCount; i++) {
            car.move(randomNumber);
        }

        CarDto carDto = car.toDto();
        assertThat(carDto.getPosition()).isEqualTo(initialPosition + movingCount);
    }

    @DisplayName("자동차는 random값이 3 이하의 값일 경우 멈춘다.")
    @ParameterizedTest
    @MethodSource("provideMovingCountWithUnMovableNumber")
    void stopIfRandomNumberIsLessThanEqualThree(String carName, int movingCount, int randomNumber) {
        Car car = new Car(carName);

        for (int i = 0; i < movingCount; i++) {
            car.move(randomNumber);
        }

        CarDto carDto = car.toDto();
        assertThat(carDto.getPosition()).isOne();
    }

    public static Stream<Arguments> provideMovingCountWithMovableNumber() {
        return Stream.of(
                Arguments.of("avante", 1, 4),
                Arguments.of("sonata", 2, 9)
        );
    }

    public static Stream<Arguments> provideMovingCountWithUnMovableNumber() {
        return Stream.of(
                Arguments.of("grandeur", 2, 1),
                Arguments.of("genesis", 2, 3)
        );
    }

}
package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.dto.CarDto;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차는 random값이 4 이상일 경우 전진한다.")
    @ParameterizedTest
    @CsvSource({"'car1', 1, 4", "'car2', 2, 9"})
    void moveIfRandomNumberIsGreaterThanEqualFour(String carName, int movingCount, int randomNumber) {
        Car car = new Car(carName);

        for (int i = 0; i < movingCount; i++) {
            car.move(randomNumber);
        }

        CarDto carDto = car.toDto();
        assertThat(carDto.getPosition()).isEqualTo(movingCount);
    }

    @DisplayName("자동차는 random값이 3 이하의 값일 경우 멈춘다.")
    @ParameterizedTest
    @CsvSource({"'car1', 2, 1", "'car2', 2, 3"})
    void stopIfRandomNumberIsLessThanEqualThree(String carName, int movingCount, int randomNumber) {
        Car car = new Car(carName);

        for (int i = 0; i < movingCount; i++) {
            car.move(randomNumber);
        }

        CarDto carDto = car.toDto();
        assertThat(carDto.getPosition()).isZero();
    }

}
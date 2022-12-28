package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

public class CarTest {
    @DisplayName("랜덤 값이 4 이상일 때에 전진하는가")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤_값이_4_이상일_때_전진(int value){
        Car car = new Car("J");
        car.move(bound -> value);
        Assertions.assertThat(car.position()).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 3 이하일 때에 멈추는가")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤_값이_3_이하일_때_정지(int value){
        Car car = new Car("J");
        car.move(bound -> value);
        Assertions.assertThat(car.position()).isEqualTo(0);
    }
}

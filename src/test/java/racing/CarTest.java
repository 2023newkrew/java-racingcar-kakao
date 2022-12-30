package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @DisplayName("다섯 글자 이하 이름 예외 처리 테스트")
    @Test
    public void nameExceptionNotThrowTest() {
        String shortName = "choi";
        assertDoesNotThrow(() -> new Car(shortName));
    }

    @DisplayName("다섯 글자 초과 이름 예외 처리 테스트")
    @Test
    public void nameExceptionThrowTest() {
        String longName = "jerrie";
        assertThrows(RuntimeException.class, () -> new Car(longName));
    }

    @DisplayName("랜덤 숫자가 4 미만일 때 자동차 정지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void carStopTest(int numberUnderFour) {
        int nowPosition = 5;
        Car car = new Car(nowPosition, "test") {
            @Override
            protected int createRandomNumber() {
                return numberUnderFour;
            }
        };
        car.carEvent();
        assertThat(car.getPosition()).isEqualTo(nowPosition);
    }

    @DisplayName("랜덤 숫자가 4 이상일 때 자동차 전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void carForwardTest(int numberOverThree) {
        int nowPosition = 5;
        Car car = new Car(nowPosition, "test") {
            @Override
            protected int createRandomNumber() {
                return numberOverThree;
            }
        };
        car.carEvent();
        assertThat(car.getPosition()).isEqualTo(nowPosition + 1);
    }

}

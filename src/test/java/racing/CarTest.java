package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("자동차 정지 테스트")
    @Test
    public void carStopTest() {
        int nowPosition = 5;
        Car car = new Car(nowPosition, "test");
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(nowPosition);
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    public void carForwardTest() {
        int nowPosition = 5;
        Car car = new Car(nowPosition, "test");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(nowPosition + 1);
    }

}

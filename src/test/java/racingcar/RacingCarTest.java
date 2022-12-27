package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("자동차의 이름을 부여한다.")
    void giveACarName() {
        String carName = "avante";
        Car car = new Car(carName);

        assertThat(car.isSameName(carName)).isTrue();
    }

}

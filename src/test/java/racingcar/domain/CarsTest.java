package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    List<Car> cars = Arrays.asList(
            new Car(1, "aa"),
            new Car(2, "bb"),
            new Car(3, "cc"),
            new Car(4, "dd"),
            new Car(4, "ee")
    );

    @DisplayName("우승자들을 찾아서 그 목록을 반환해야 한다.")
    @Test
    void findWinners() {
        Cars cars = new Cars(this.cars);

        assertThat(cars.findWinners()).isEqualTo(Arrays.asList(new Car(4, "dd"), new Car(4, "ee")));
    }
}

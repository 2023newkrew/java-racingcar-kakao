package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
    }

    @Test
    void getWinners() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car(1, "aa"));
        cars.add(new Car(2, "bb"));
        cars.add(new Car(3, "cc"));
        cars.add(new Car(4, "dd"));
        cars.add(new Car(4, "ee"));

        assertThat(this.racingService.getWinners(cars)).isEqualTo(Arrays.asList(new Car(4, "dd"), new Car(4, "ee")));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void shouldNotMove(int no) {
        assertThat(this.racingService.getActionResult(no)).isEqualTo(CarAction.STAY);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void shouldMove(int no) {
        assertThat(this.racingService.getActionResult(no)).isEqualTo(CarAction.FORWARD);
    }
}

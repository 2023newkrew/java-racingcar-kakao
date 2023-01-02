package CarRacing.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        Car[] carArray = new Car[]{new Car("pobi", 5), new Car("crong", 4), new Car("honux", 5)};
        cars = new Cars(carArray);
    }

    @DisplayName("자동차 이름 배열 길이가 정상인 경우 테스트")
    @Test
    public void correctCarNamesLengthTest() {
        assertDoesNotThrow(() -> {
            cars.validateCarNamesLength(3);
        });
    }

    @DisplayName("자동차 이름 배열 길이가 비정상인 경우 테스트")
    @Test
    public void wrongCarNamesLengthTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            cars.validateCarNamesLength(0);
        });
    }

    @DisplayName("자동차 배열에서 최대 포지션을 제대로 구하는지 테스트")
    @Test
    public void getMaxPositionTest() {
        assertThat(cars.getMaxPosition().getPosition()).isEqualTo(5);
    }

    @DisplayName("자동차 배열에서 최대 포지션으로 우승자들을 제대로 구하는지 테스트")
    @Test
    public void getWinnersTest() {
        assertThat(cars.getWinners(new CarPosition(5))).isEqualTo(
                Arrays.asList(new CarName("pobi"), new CarName("honux")));
    }

    @DisplayName("자동차 배열에서 로그를 제대로 구하는지 테스트")
    @Test
    public void getRacingLogTest() {
        RacingLog[] racingLogs = new RacingLog[]{new RacingLog(new CarName("pobi"), new CarPosition(5)),
                new RacingLog(new CarName("crong"), new CarPosition(4)),
                new RacingLog(new CarName("honux"), new CarPosition(5))};
        assertThat(cars.getRacingLog()).isEqualTo(racingLogs);
    }
}

package CarRacing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingTest {
    private Racing racing;
    private Racing racingWithCars;

    @BeforeEach
    void setUp() {
        racing = new Racing("pobi,crong,honux", "5");
        Car[] cars = new Car[]{new Car("pobi", 5), new Car("crong", 4), new Car("honux", 5)};
        racingWithCars = new Racing(cars, 5);
    }

    @DisplayName("레이싱 시도 횟수가 정상인 경우 테스트")
    @Test
    public void correctRacingCountTest() {
        assertDoesNotThrow(() -> {
            racing.validateRacingCount("5");
        });
    }

    @DisplayName("레이싱 시도 횟수가 비정상인 경우 테스트")
    @Test
    public void wrongRacingCountTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            racing.validateRacingCount("abc");
        });
    }
    @DisplayName("이름 배열로 자동차 배열을 생성한 후 길이가 일치하는지 테스트")
    @Test
    public void makeCarListTest() {
        Car[] cars = racing.getCarList();
        assertThat(cars.length).isEqualTo(3);
    }

    @DisplayName("자동차 이름 배열 길이가 정상인 경우 테스트")
    @Test
    public void correctCarNamesLengthTest() {
        assertDoesNotThrow(() -> {
           racing.validateCarNamesLength(3);
        });
    }

    @DisplayName("자동차 이름 배열 길이가 비정상인 경우 테스트")
    @Test
    public void wrongCarNamesLengthTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            racing.validateCarNamesLength(0);
        });
    }

    @DisplayName("자동차 배열에서 최대 포지션을 제대로 구하는지 테스트")
    @Test
    public void getMaxPositionTest() {
        assertThat(racingWithCars.getMaxPosition().getPosition()).isEqualTo(5);
    }

    @DisplayName("자동차 배열에서 우승자를 제대로 구하는지 테스트")
    @Test
    public void decideWinnersTest() {
        racingWithCars.decideWinners();
        assertThat(racingWithCars.getWinners()).isEqualTo(Arrays.asList(new CarName("pobi"), new CarName("honux")));
    }

    @DisplayName("우승자 이름 목록이 제대로 갱신되는지 테스트")
    @Test
    public void addWinnerTest() {
        racing.addWinner(new CarName("leo"));
        assertThat(racing.getWinners()).isEqualTo(Arrays.asList(new CarName("leo")));
    }
}

package CarRacing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingTest {
    private Racing racingWithCars;

    @BeforeEach
    void setUp() {
        Car[] cars = new Car[]{new Car("pobi", 5), new Car("crong", 4), new Car("honux", 5)};
        racingWithCars = new Racing(new Cars(cars), 5);
    }

    @DisplayName("자동차 배열에서 우승자를 제대로 구하는지 테스트")
    @Test
    public void decideWinnersTest() {
        racingWithCars.decideWinners();
        assertThat(racingWithCars.getWinners()).isEqualTo(Arrays.asList(new CarName("pobi"), new CarName("honux")));
    }
}

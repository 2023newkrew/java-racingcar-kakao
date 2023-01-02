package CarRacing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test", 5);
    }

    @DisplayName("자동차 전진이 제대로 작동하는지 테스트")
    @ParameterizedTest
    @CsvSource({"true, 6", "false, 5"})
    public void moveCarTest(boolean move, int position) {
        car.moveCar(() -> move);
        assertThat(car.getPosition().getPosition()).isEqualTo(position);
    }

    @DisplayName("우승자의 위치와 같으면 true를 반환하는지 테스트")
    @Test
    public void isWinnerTest() {
        assertThat(car.isWinner(new CarPosition(5))).isEqualTo(true);
    }

    @DisplayName("우승자의 위치와 다르면 false를 반환하는지 테스트")
    @Test
    public void getLoserNameTest() {
        assertThat(car.isWinner(new CarPosition(6))).isEqualTo(false);
    }
}

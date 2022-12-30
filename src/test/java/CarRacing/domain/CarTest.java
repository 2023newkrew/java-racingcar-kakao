package CarRacing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    private Car car;
    private Car positionCar;

    @BeforeEach
    void setUp() {
        car = new Car("test");
        positionCar = new Car("test", 5);
    }
    @DisplayName("적절한 길이(1이상 5이하)의 자동차 이름 예외 처리 테스트")
    @Test
    public void validateCorrectCarNameTest() {
        String correct_name = "pobi";
        assertDoesNotThrow(() -> {
            car.validateName(correct_name);
        });
    }

    @DisplayName("적절하지 않은 길이(0, 6이상)의 자동차 이름 예외 처리 테스트")
    @Test
    public void validateWrongCarNameTest() {
        String wrong_name = "pororo";
        assertThrows(RuntimeException.class, () -> {
            car.validateName(wrong_name);
        });
    }

    @DisplayName("자동차 전진이 제대로 작동하는지 테스트")
    @ParameterizedTest
    @CsvSource({"true, 6", "false, 5"})
    public void moveCarTest(boolean move, int position) {
        positionCar.moveCar(() -> move);
        assertThat(positionCar.getPosition()).isEqualTo(position);
    }

    @DisplayName("자동차의 포지션과 최대 포지션의 비교가 잘 이루어지는지 테스트")
    @ParameterizedTest
    @CsvSource({"6, 6", "4, 5", "5, 5"})
    public void getMaxPositionTest(int maxPosition, int newMaxPosition) {
        assertThat(positionCar.getMaxPosition(maxPosition)).isEqualTo(newMaxPosition);
    }

    @DisplayName("우승자면 이름을 반환하는지 테스트")
    @ParameterizedTest
    @CsvSource({"5, test", "6,"})
    public void getWinnerNameTest(int maxPosition, String winnerName) {
        assertThat(positionCar.getWinnerName(maxPosition)).isEqualTo(winnerName);
    }
}

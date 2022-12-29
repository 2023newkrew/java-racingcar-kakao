package CarRacing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;
    private Car positionCar;

    @BeforeEach
    void setUp() {
        car = new Car("test");
        positionCar = new Car("test", 5);
    }

    @DisplayName("랜덤한 숫자가 0부터 9사이로 생성되는지 테스트")
    @Test
    public void createRandomNumberTest() {
        assertThat(car.createRandomNumber()).isBetween(0, 9);
    }

    @DisplayName("랜덤 넘버가 0이상 3이하 일때 자동차가 움직이지 않는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void isNotMoveTest(int randomNumber) {
        assertThat(car.isMove(randomNumber)).isEqualTo(false);
    }

    @DisplayName("랜덤 넘버가 4이상 9이하 일때 자동차가 움직이는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void isMoveTest(int randomNumber) {
        assertThat(car.isMove(randomNumber)).isEqualTo(true);
    }

    @DisplayName("자동차 전진이 제대로 작동하는지 테스트")
    @ParameterizedTest
    @CsvSource({"true, 6", "false, 5"})
    public void moveCarTest(boolean move, int position) {
        positionCar.moveCar(move);
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

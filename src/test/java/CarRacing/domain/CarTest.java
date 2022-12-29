package CarRacing.domain;

import CarRacing.domain.Car;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    public void createRandomNumberTest() {
        assertThat(car.createRandomNumber()).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void isNotMoveTest(int randomNumber) {
        assertThat(car.isMove(randomNumber)).isEqualTo(false);
    }
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void isMoveTest(int randomNumber) {
        assertThat(car.isMove(randomNumber)).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({"true, 6", "false, 5"})
    public void moveCarTest(boolean move, int position) {
        positionCar.moveCar(move);
        assertThat(positionCar.getPosition()).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource({"6, 6", "4, 5", "5, 5"})
    public void getMaxPositionTest(int maxPosition, int newMaxPosition) {
        assertThat(positionCar.getMaxPosition(maxPosition)).isEqualTo(newMaxPosition);
    }

    @ParameterizedTest
    @CsvSource({"5, test", "6,"})
    public void getWinnerNameTest(int maxPosition, String winnerName) {
        assertThat(positionCar.getWinnerName(maxPosition)).isEqualTo(winnerName);
    }

    @Test
    public void toStringTest() {
        assertThat(positionCar.toString()).isEqualTo("test : -----");
    }
}

package CarRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    public void isMoveTest() {
        assertThat(car.isMove(3)).isEqualTo(false);
        assertThat(car.isMove(4)).isEqualTo(true);
    }

    @Test
    public void moveCarTest() {
        car.moveCar(true);
        assertThat(car.getPosition()).isEqualTo(2);

        car.moveCar(false);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    public void getMaxPositionTest() {
        assertThat(positionCar.getMaxPosition(6)).isEqualTo(6);
        assertThat(positionCar.getMaxPosition(4)).isEqualTo(5);
        assertThat(positionCar.getMaxPosition(5)).isEqualTo(5);
    }

    @Test
    public void getWinnerNameTest() {
        assertThat(positionCar.getWinnerName(5)).isEqualTo("test");
        assertThat(positionCar.getWinnerName(6)).isEqualTo(null);
    }

    @Test
    public void toStringTest() {
        assertThat(positionCar.toString()).isEqualTo("test : -----");
    }
}

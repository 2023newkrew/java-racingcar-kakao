package CarRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;
    private Car positionCar;

    @BeforeEach
    void setUp() {
        car = new CarBuilder().name("test").buildCar();
        positionCar = new CarBuilder().name("test").position(5).buildCar();
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
}

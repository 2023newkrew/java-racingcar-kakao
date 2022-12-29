package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    private Car car;
    private Car positionCar;

    @BeforeEach
    void setUp() {
        car = new Car("test");
        positionCar = new Car(5, "test");
    }

    @Test
    public void nameExceptionNotThrowTest() {
        assertDoesNotThrow(() -> new Car("choi"));
    }

    @Test
    public void nameExceptionThrowTest() {
        assertThrows(RuntimeException.class, () -> new Car("jerrie"));
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
    public void getWinnerNameTest() {
        assertThat(positionCar.getWinnerName(5)).isEqualTo("test");
        assertThat(positionCar.getWinnerName(6)).isEqualTo(null);
    }

    @Test
    public void toStringTest() {
        assertThat(positionCar.toString()).isEqualTo("test : -----");
    }
}

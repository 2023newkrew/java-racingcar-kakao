package CarRacing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void moveCarTest() {
        Car car = new Car();
        car.moveCar(true);
        assertThat(car.getPosition()).isEqualTo(2);

        car.moveCar(false);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}

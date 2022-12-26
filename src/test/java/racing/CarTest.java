package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    public void isMove() {
        Car car = new Car();
        assertThat(car.isMove(4)).isEqualTo(true);
    }

    @Test
    public void isStop() {
        Car car = new Car();
        assertThat(car.isMove(3)).isEqualTo(false);
    }
}

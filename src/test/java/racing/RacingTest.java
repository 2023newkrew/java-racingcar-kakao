package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Racing;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @Test
    public void makeCarListTest() {
        String[] names = new String[] {"pobi", "crong", "honux"};
        Car[] cars = racing.makeCarList(names);
        assertThat(cars.length).isEqualTo(names.length);
    }

}

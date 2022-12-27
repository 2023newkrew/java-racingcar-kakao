package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
        racing.setCount(5);
        racing.addCars(Arrays.asList("davi", "sean"));
    }

    @Test
    void racingCreateCar() {
        assertThat(racing.getCarList()).hasSize(2);
        assertThat(racing.getCarList().get(0).getName()).isEqualTo("davi");
        assertThat(racing.getCarList().get(0).getDistance()).isEqualTo(0);
        assertThat(racing.getCarList().get(1).getName()).isEqualTo("sean");
        assertThat(racing.getCarList().get(1).getDistance()).isEqualTo(0);
    }

    @Test
    void racingProgress() {
        racing.doStep();
        racing.getCarList().forEach((car)->{
            assertThat(car.getDistance()).isGreaterThanOrEqualTo(0);
        });
        assertThat(racing.getCount()).isEqualTo(4);
    }

    @Test
    void racingIsFinished() {
        while (!racing.isFinished()) {
            racing.doStep();
        }

        assertThat(racing.getCount()).isEqualTo(0);
    }

    @Test
    void racingResult() {
        while(!racing.isFinished()){
            racing.doStep();
        }
        assertThat(racing.winner()).containsAnyOf("davi", "sean");
    }
}

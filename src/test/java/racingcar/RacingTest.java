package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("자동차 이름 목록에 있는 자동차가 생성된다.")
    void racingCreateCar() {
        assertThat(racing.getCarList()).hasSize(2);
        assertThat(racing.getCarList().get(0).getName()).isEqualTo("davi");
        assertThat(racing.getCarList().get(0).getDistance()).isEqualTo(0);
        assertThat(racing.getCarList().get(1).getName()).isEqualTo("sean");
        assertThat(racing.getCarList().get(1).getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("레이싱이 진행될 때 횟수가 하나 소진된다.")
    void racingProgress() {
        racing.doStep();
        racing.getCarList().forEach((car)->{
            assertThat(car.getDistance()).isGreaterThanOrEqualTo(0);
        });
        assertThat(racing.getCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("정해진 횟수가 모두 소진되면 레이싱이 종료된다.")
    void racingIsFinished() {
        while (!racing.isFinished()) {
            racing.doStep();
        }

        assertThat(racing.getCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("레이싱 종료 후 승자 목록을 반환한다.")
    void racingResult() {
        while(!racing.isFinished()){
            racing.doStep();
        }
        assertThat(racing.winner()).containsAnyOf("davi", "sean");
    }
}

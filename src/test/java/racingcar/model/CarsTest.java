package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.StubNumberGenerator;

class CarsTest {

    private static final int MOVE = 4;
    private static final int STOP = 3;

    @DisplayName("여러 대의 자동차를 이동 혹은 정지시킨다.")
    @Test
    void moveOrStopCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);
        Cars cars = new Cars(numberGenerator, List.of(new Car("a"), new Car("b"), new Car("c")));

        cars.move();

        Positions positions = cars.getPositions();
        assertThat(positions.getPositionByName("a")).isEqualTo(1);
        assertThat(positions.getPositionByName("b")).isEqualTo(1);
        assertThat(positions.getPositionByName("c")).isEqualTo(0);
    }

    @DisplayName("가장 멀리 이동한 차가 단독 우승한다")
    @Test
    void getSoloWinner() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, STOP, STOP,
                MOVE, MOVE, MOVE
        );
        Cars cars = new Cars(numberGenerator, List.of(new Car("a"), new Car("b"), new Car("c")));

        cars.move();
        cars.move();
        cars.move();
        Winners winners = cars.getWinners();

        assertThat(winners.getWinnerCars())
                .extracting(Car::getName)
                .hasSize(1)
                .contains("a");
    }

    @DisplayName("가장 멀리 이동한 자동차가 공동 우승한다")
    @Test
    void getCoWinners() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, MOVE, MOVE,
                MOVE, MOVE, MOVE
        );
        Cars cars = new Cars(numberGenerator, List.of(new Car("a"), new Car("b"), new Car("c")));

        cars.move();
        cars.move();
        cars.move();
        Winners winners = cars.getWinners();

        assertThat(winners.getWinnerCars())
                .extracting(Car::getName)
                .hasSize(2)
                .contains("a", "b");
    }
}

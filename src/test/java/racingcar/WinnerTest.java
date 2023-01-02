package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.models.Car;
import racingcar.models.Winner;

public class WinnerTest {
    @Test
    public void testGetSingleWinner() {
        List<Car> cars = List.of(new Car("jaws", 12), new Car("jayde", 10), new Car("musc", 11));
        Winner winner = new Winner(cars);
        Assertions.assertThat(winner.getWinnerNames()).containsExactly("jaws");
    }

    @Test
    public void testMultipleWinners() {
        List<Car> cars = List.of(new Car("jaws", 12), new Car("jayde", 12), new Car("musc", 12));
        Winner winner = new Winner(cars);
        Assertions.assertThat(winner.getWinnerNames()).containsExactly("jaws", "jayde", "musc");
    }
}

package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RefereeTest {

    private final Referee referee = new Referee();

    @Test
    public void 가장_멀리간_자동차를_우승자로_판정() {
        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("jaws", 5);
        Car car3 = new Car("jayde", 5);
        List<Car> cars = Arrays.asList(car1, car2, car3);
        List<String> winners = referee.judgeWinners(cars);
        Assertions.assertThat(winners).containsExactly("jaws", "jayde");
    }

}

package racingcar;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.engine.Referee;
import racingcar.engine.model.Car;

public class RefereeTest {

    private final Referee referee = new Referee();

    @Test
    public void 우승자를_가린다() {
        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("jaws", 5);
        Car car3 = new Car("jayde", 5);
        List<Car> cars = Arrays.asList(car1, car2, car3);
        List<String> winners = referee.judgeWinner(cars);
        Assertions.assertThat(winners).containsExactly("jaws", "jayde");
    }


}

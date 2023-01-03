package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarsManager;

import java.util.Arrays;
import java.util.List;

public class CarsManagerTest {

    @Test
    public void 가장_멀리간_자동차를_우승자로_판정() {
        Car car1 = new Car("pobi", 3);
        Car car2 = new Car("jaws", 5);
        Car car3 = new Car("jayde", 5);
        CarsManager carsManager = new CarsManager(Arrays.asList(car1, car2, car3));
        List<String> winners = carsManager.findWinners();
        Assertions.assertThat(winners).containsOnly("jaws", "jayde");
    }

}

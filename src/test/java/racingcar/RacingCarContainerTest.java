package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarContainer;
import racingcar.domain.model.RacingCar;

import java.util.List;

public class RacingCarContainerTest {

    @Test
    void duplicatedNameException() {
        CarContainer carContainer = new CarContainer();
        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    carContainer.add(new RacingCar("lion"));
                    carContainer.add(new RacingCar("lion"));
                });
    }

    @Test
    void selectWinners() {
        CarContainer carContainer = new CarContainer();
        RacingCar racingCar1 = new RacingCar("car1");
        RacingCar racingCar2 = new RacingCar("car2");
        RacingCar racingCar3 = new RacingCar("car3");
        racingCar1.move(5);
        racingCar2.move(5);
        carContainer.add(racingCar1);
        carContainer.add(racingCar2);
        carContainer.add(racingCar3);
        List<RacingCar> winner = carContainer.selectWinners();
        Assertions.assertThat(winner)
                .containsOnly(racingCar1, racingCar2);
    }
}

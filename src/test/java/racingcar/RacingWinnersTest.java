package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarGroup;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingWinnersTest {
    @Test
    @DisplayName("경기 종료후 단일 우승자일 때 우승자를 찾을 수 있다.")
    void winnerTest() {
        ArrayList<RacingCar> carsList = new ArrayList<>();
        carsList.add(new RacingCar("a", 1));
        carsList.add(new RacingCar("b", 2));
        carsList.add(new RacingCar("c", 3));
        carsList.add(new RacingCar("d", 4));
        carsList.add(new RacingCar("e", 5));

        RacingCarGroup racingCars = new RacingCarGroup(carsList);

        assertThat(racingCars.getWinners()).containsExactly(new RacingCar("e", 5));
    }

    @Test
    @DisplayName("경기 종료후 복수 우승자일 때 우승자들을 찾을 수 있다.")
    void winnersTest() {
        ArrayList<RacingCar> carsList = new ArrayList<>();
        carsList.add(new RacingCar("a", 1));
        carsList.add(new RacingCar("b", 5));
        carsList.add(new RacingCar("c", 3));
        carsList.add(new RacingCar("d", 5));
        carsList.add(new RacingCar("e", 4));

        RacingCarGroup racingCars = new RacingCarGroup(carsList);

        assertThat(racingCars.getWinners()).containsExactly(new RacingCar("b", 5), new RacingCar("d", 5));
    }
}

package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameRefereeTest {
    @Test
    void findWinners1() {
        //given
        RacingCar car1 = new RacingCar("car1", 3);
        RacingCar car2 = new RacingCar("car2", 5);
        RacingCar car3 = new RacingCar("car3", 5);
        List<RacingCar> racingCars = Arrays.asList(car1, car2, car3);

        //when
        RacingGameReferee racingGameReferee = new RacingGameReferee();
        List<RacingCar> winners = racingGameReferee.findWinners(racingCars);

        //then
        assertThat(winners).hasSize(2)
                .containsExactly(car2, car3);
    }

    @Test
    void findWinners2() {
        //given
        RacingCar car1 = new RacingCar("car1", 3);
        RacingCar car2 = new RacingCar("car2", 4);
        RacingCar car3 = new RacingCar("car3", 5);
        List<RacingCar> racingCars = Arrays.asList(car1, car2, car3);

        //when
        RacingGameReferee racingGameReferee = new RacingGameReferee();
        List<RacingCar> winners = racingGameReferee.findWinners(racingCars);

        //then
        assertThat(winners).hasSize(1)
                .containsExactly(car3);
    }

    @Test
    void findWinners3() {
        //given
        RacingCar car1 = new RacingCar("car1", 3);
        List<RacingCar> racingCars = List.of(car1);

        //when
        RacingGameReferee racingGameReferee = new RacingGameReferee();
        List<RacingCar> winners = racingGameReferee.findWinners(racingCars);

        //then
        assertThat(winners).hasSize(1)
                .containsExactly(car1);
    }
}

package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.view.RacingGameInfoReader;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameInfoReaderTest {

    @Test
    void readRacingCars(){
        // given
        String input = "car1,car2,car3";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RacingGameInfoReader racingGameInfoReader = new RacingGameInfoReader();

        // when
        List<RacingCar> racingCars = racingGameInfoReader.readRacingCars();

        // then
        assertThat(racingCars).hasSize(3);
        assertThat(racingCars).contains(new RacingCar("car1"), new RacingCar("car2"), new RacingCar("car3"));
    }

    @Test
    void readRacingCars_singleCar(){
        // given
        String input = "car1";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RacingGameInfoReader racingGameInfoReader = new RacingGameInfoReader();

        // when
        List<RacingCar> racingCars = racingGameInfoReader.readRacingCars();

        // then
        assertThat(racingCars).hasSize(1);
        assertThat(racingCars).contains(new RacingCar("car1"));
    }

    @Test
    void readRacingCars_blank(){
        // given
        String input = "car1,,car3";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RacingGameInfoReader racingGameInfoReader = new RacingGameInfoReader();

        // then
        assertThatThrownBy(() -> racingGameInfoReader.readRacingCars()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readRacingCars_longName(){
        // given
        String input = "car1,carcar2,car3";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RacingGameInfoReader racingGameInfoReader = new RacingGameInfoReader();

        // then
        assertThatThrownBy(() -> racingGameInfoReader.readRacingCars()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readRound(){
        // given
        String input = "5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RacingGameInfoReader racingGameInfoReader = new RacingGameInfoReader();

        // when
        int round = racingGameInfoReader.readRound();

        // then
        assertThat(round).isEqualTo(5);
    }
}

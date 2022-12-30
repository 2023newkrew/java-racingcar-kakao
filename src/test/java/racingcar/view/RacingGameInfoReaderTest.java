package racingcar.view;

import org.junit.jupiter.api.*;
import racingcar.domain.RacingCar;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameInfoReaderTest {

    @Test
    @DisplayName("차 여러대 이름받아서 RacingCar 객체배열 생성이 잘 되는지 테스트")
    void readRacingCars(){
        // given
        String input = "car1,car2,car3";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        List<RacingCar> racingCars = RacingGameInfoReader.getInstance().readRacingCars();

        // then
        assertThat(racingCars).hasSize(3);
        assertThat(racingCars).contains(new RacingCar("car1"), new RacingCar("car2"), new RacingCar("car3"));
    }

    @Test
    @DisplayName("차 1대 이름받아서 RacingCar 객체배열 생성이 잘 되는지 테스트")
    void readRacingCars_singleCar(){
        // given
        String input = "car1";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        List<RacingCar> racingCars = RacingGameInfoReader.getInstance().readRacingCars();

        // then
        assertThat(racingCars).hasSize(1);
        assertThat(racingCars).contains(new RacingCar("car1"));
    }

    @Test
    @DisplayName("차 0대 이름받아서 RacingCar 객체배열 생성이 잘 되는지 테스트")
    void readRacingCars_blank(){
        // given
        String input = "car1,,car3";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // then
        assertThatThrownBy(() -> RacingGameInfoReader.getInstance().readRacingCars()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("차 이름이 5글자 초과할 떄 에러발생 테스트")
    void readRacingCars_longName(){
        // given
        String input = "car1,carcar2,car3";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // then
        assertThatThrownBy(() -> RacingGameInfoReader.getInstance().readRacingCars()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라운드 횟수 입력 테스트")
    void readRound(){
        // given
        String input = "5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        int round = RacingGameInfoReader.getInstance().readRound();

        // then
        assertThat(round).isEqualTo(5);
    }
}

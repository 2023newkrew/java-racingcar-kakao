package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameInputViewTest {

    RacingGameInputView racingGameInputView;

    @AfterEach
    void tearDown() {
        racingGameInputView.close();
    }

    @DisplayName("n개의 레이싱카의 이름을 읽어서 RacingCars로 반환한다")
    @Test
    void readRacingCars(){
        // given
        String input = "car1,car2,car3";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        racingGameInputView = new RacingGameInputView();
        RacingCars racingCars = racingGameInputView.readRacingCars();

        // then
        assertThat(racingCars.getNumOfRacingCars()).isEqualTo(3);
        assertThat(racingCars).isEqualTo(new RacingCars(new String[]{"car1", "car2", "car3"}));
    }

    @DisplayName("1개의 레이싱카의 이름을 읽어서 RacingCars로 반환한다")
    @Test
    void readRacingCars_singleCar(){
        // given
        String input = "car1";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        racingGameInputView = new RacingGameInputView();

        // when
        RacingCars racingCars = racingGameInputView.readRacingCars();

        // then
        assertThat(racingCars.getNumOfRacingCars()).isEqualTo(1);
        assertThat(racingCars).isEqualTo(new RacingCars(new String[]{"car1"}));
    }

    @DisplayName("레이싱카 이름이 공백이거나 5글자를 초과하면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"car1,,car3", "car1,carcar2,car3"})
    void readRacingCars_throwEx(String input) {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        racingGameInputView = new RacingGameInputView();

        // then
        assertThatThrownBy(racingGameInputView::readRacingCars)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수를 읽어서 int로 반환한다")
    @Test
    void readRound(){
        // given
        String input = "5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        racingGameInputView = new RacingGameInputView();
        int round = racingGameInputView.readRound();

        // then
        assertThat(round).isEqualTo(5);
    }
}

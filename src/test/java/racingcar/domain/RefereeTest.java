package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RefereeTest {

    @DisplayName("플레이 할 라운드 횟수, 차 리스트, 숫자 선택 정책을 넘겨 Referee를 생성할 수 있다.")
    @Test
    void create_referee_test() {
        // given
        int roundToPlay = 5;
        List<Car> registeredCars = List.of(new Car("car1"), new Car("car2"));
        NumberSelector numberSelector = new RandomNumberSelector();

        // when & then
        assertDoesNotThrow(() -> new Referee(roundToPlay, registeredCars, numberSelector));
    }

    @DisplayName("플레이 할 라운드 횟수는 음수가 되어서는 안된다.")
    @Test
    void validate_round_to_play_test() {
        // given
        int invalidRoundToPlay = -2;
        List<Car> registeredCars = List.of(new Car("car1"), new Car("car2"));
        NumberSelector numberSelector = new RandomNumberSelector();

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Referee(invalidRoundToPlay, registeredCars, numberSelector))
                .withMessage("라운드는 양수여야 합니다.");
    }

    @DisplayName("Referee는 번호를 뽑아 전진/멈춤 중 하나의 행동을 명령할 수 있 - 해당 테스트는 전진")
    @Test
    void referee_move_cars_test() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> registeredCars = List.of(car1, car2);

        NumberSelector moveNumberSelector = new MoveNumberSelector();
        Referee referee = new Referee(5, registeredCars, moveNumberSelector);

        // when
        referee.moveCars();

        // then
        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
    }

    @DisplayName("Referee는 번호를 뽑아 전진/멈춤 중 하나의 행동을 명령할 수 있다 - 해당 테스트는 멈춤")
    @Test
    void referee_stay_cars_test() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> registeredCars = List.of(car1, car2);

        NumberSelector stayNumberSelector = new StayNumberSelector();
        Referee referee = new Referee(5, registeredCars, stayNumberSelector);

        // when
        referee.moveCars();

        // then
        assertThat(car1.getPosition()).isEqualTo(0);
        assertThat(car2.getPosition()).isEqualTo(0);
    }


    @DisplayName("Referee는 번호를 뽑아 전진/멈춤 중 하나의 행동을 명령한다 - 해당 테스트는 멈춤")
    @Test
    void referee_cannot_move_cars_when_game_ends_test() {
        // given
        int roundToPlay = 5;
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> registeredCars = List.of(car1, car2);

        NumberSelector stayNumberSelector = new StayNumberSelector();
        Referee referee = new Referee(roundToPlay, registeredCars, stayNumberSelector);

        // when
        for (int i = 0; i < roundToPlay; i++) {
            referee.moveCars();
        }

        // then
        assertThatThrownBy(() -> referee.moveCars())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("게임이 종료되었습니다.");
    }

    @DisplayName("Referee는 정해진 라운드가 모두 종료되었는지 검사할 수 있다.")
    @Test
    void referee_check_game_end_test() {
        // given
        int roundToPlay = 3;
        List<Car> registeredCars = List.of(new Car("car1"), new Car("car2"));
        Referee referee = new Referee(roundToPlay, registeredCars, new MoveNumberSelector());

        // when
        for (int i = 0; i < roundToPlay; i++) {
            referee.moveCars();
        }
        boolean gameEnded = referee.isGameEnded();

        // then
        assertThat(gameEnded).isTrue();
    }

    @DisplayName("Referee는 라운드가 진행중인 상태인지 검사할 수 있다.")
    @Test
    void referee_check_game_is_playing_test() {
        // given
        int roundToPlay = 3;
        List<Car> registeredCars = List.of(new Car("car1"), new Car("car2"));
        Referee referee = new Referee(roundToPlay, registeredCars, new MoveNumberSelector());

        // when
        boolean gamePlaying = referee.isGamePlaying();

        // then
        assertThat(gamePlaying).isTrue();
    }

    @DisplayName("Referee는 우승자를 확인할 수 있다.")
    @Test
    void referee_check_winner_test() {
        // given
        int roundToPlay = 3;
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> registeredCars = List.of(car1, car2);
        NumberSelector moveNumberSelector = new MoveNumberSelector();
        Referee referee = new Referee(roundToPlay, registeredCars, moveNumberSelector);

        // when
        for (int i = 0; i < roundToPlay; i++) {
            referee.moveCars();
        }
        List<Car> winners = referee.announceWinners();

        // then
        assertThat(winners.get(0)).isEqualTo(car1);
        assertThat(winners.get(1)).isEqualTo(car2);
    }

    @DisplayName("Referee는 각 라운드 결과를 확인할 수 있다.")
    @Test
    void announce_round_result_test() {
        // given
        int roundToPlay = 3;
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> registeredCars = List.of(car1, car2);
        NumberSelector moveNumberSelector = new MoveNumberSelector();
        Referee referee = new Referee(roundToPlay, registeredCars, moveNumberSelector);

        // when
        List<Car> roundResult = referee.announceRoundResult();

        // then
        assertThat(roundResult.get(0)).isEqualTo(car1);
        assertThat(roundResult.get(1)).isEqualTo(car2);
    }
}

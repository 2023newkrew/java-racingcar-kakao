package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class RefereeTest {

    @Test
    void create_referee_test() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> registeredCars = List.of(car1, car2, car3);

        Referee referee = new Referee(5, registeredCars, new RandomNumberSelector());

        int roundToPlay = referee.getRoundToPlay();
        int currentRound = referee.getCurrentRound();
        List<Car> cars = referee.getRegisteredCars();

        assertThat(roundToPlay).isEqualTo(5);
        assertThat(currentRound).isEqualTo(0);
        assertThat(cars).isEqualTo(registeredCars);
    }

    @Test
    void validate_round_to_play_test() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> registeredCars = List.of(car1, car2);

        int invalidRoundToPlay = -2;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Referee(invalidRoundToPlay, registeredCars, new RandomNumberSelector()))
                .withMessage("라운드는 양수여야 합니다.");
    }

    @Test
    void referee_stay_cars_test() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> registeredCars = List.of(car1, car2, car3);

        NumberSelector stayNumberSelector = new StayNumberSelector();
        Referee referee = new Referee(5, registeredCars, stayNumberSelector);

        referee.moveCars();

        assertThat(car1.getPosition()).isEqualTo(0);
        assertThat(car2.getPosition()).isEqualTo(0);
        assertThat(car3.getPosition()).isEqualTo(0);
    }

    @Test
    void referee_move_cars_test() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> registeredCars = List.of(car1, car2, car3);

        NumberSelector moveNumberSelector = new MoveNumberSelector();
        Referee referee = new Referee(5, registeredCars, moveNumberSelector);

        referee.moveCars();

        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
        assertThat(car3.getPosition()).isEqualTo(1);
    }

    @Test
    void referee_check_game_end_test() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> registeredCars = List.of(car1, car2, car3);

        NumberSelector moveNumberSelector = new MoveNumberSelector();
        Referee referee = new Referee(3, registeredCars, moveNumberSelector);

        referee.moveCars();
        boolean isGameEnded1 = referee.isGameEnded();
        assertThat(isGameEnded1).isFalse();

        referee.moveCars();
        boolean isGameEnded2 = referee.isGameEnded();
        assertThat(isGameEnded2).isFalse();

        referee.moveCars();
        boolean isGameEnded3 = referee.isGameEnded();
        assertThat(isGameEnded3).isTrue();
    }

    @Test
    void referee_check_winner_test() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> registeredCars = List.of(car1, car2, car3);

        NumberSelector moveNumberSelector = new MoveNumberSelector();
        Referee referee = new Referee(3, registeredCars, moveNumberSelector);

        referee.moveCars();
        referee.moveCars();
        referee.moveCars();

        List<String> winners = referee.announceWinners();

        assertThat(winners.get(0)).isEqualTo("car1");
        assertThat(winners.get(1)).isEqualTo("car2");
        assertThat(winners.get(2)).isEqualTo("car3");
    }
}

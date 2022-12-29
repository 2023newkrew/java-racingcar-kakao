package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.response.CarWinnerResponse;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RacingGameTest {

    @DisplayName("차 이름과 플레이할 라운드를 넘겨 레이싱 게임을 생성할 수 있다.")
    @Test
    void create_racing_game_test() {
        String carNames = "pobi,crong,honux";
        int roundToPlay = 5;

        assertDoesNotThrow(() -> new RacingGame(carNames, roundToPlay, new RandomNumberSelector()));
    }

    @DisplayName("게임에 할당된 모든 라운드가 종료되면 우승자를 확인할 수 있다.")
    @Test
    void check_winners_test() {
        String carNames = "pobi,crong,honux";
        int roundToPlay = 2;

        RacingGame racingGame = new RacingGame(carNames, roundToPlay, new MoveNumberSelector());
        for (int i = 0; i < roundToPlay; i++) {
            racingGame.proceedRound();
        }

        List<CarWinnerResponse> gameWinnersResult = racingGame.announceWinners();
        assertThat(gameWinnersResult.get(0).getCarName()).isEqualTo("pobi");
        assertThat(gameWinnersResult.get(1).getCarName()).isEqualTo("crong");
        assertThat(gameWinnersResult.get(2).getCarName()).isEqualTo("honux");
    }

    @DisplayName("게임이 진행중이라면, 진행중인 상태임을 확인할 수 있다.")
    @Test
    void is_game_playing_test() {
        String carNames = "pobi,crong,honux";
        int roundToPlay = 2;

        RacingGame racingGame = new RacingGame(carNames, roundToPlay, new MoveNumberSelector());

        boolean gamePlaying = racingGame.isGamePlaying();
        assertThat(gamePlaying).isTrue();
    }

    @DisplayName("게임이 종료되었다면, 종료된 상태임을 확인할 수 있다.")
    @Test
    void is_game_ended_test() {
        String carNames = "pobi,crong,honux";
        int roundToPlay = 2;

        RacingGame racingGame = new RacingGame(carNames, roundToPlay, new MoveNumberSelector());
        racingGame.proceedRound();
        racingGame.proceedRound();

        boolean gameEnded = racingGame.isGameEnded();
        assertThat(gameEnded).isTrue();
    }
}

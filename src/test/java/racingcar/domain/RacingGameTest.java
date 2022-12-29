package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.response.CarRoundResultResponse;
import racingcar.controller.response.CarWinnerResponse;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RacingGameTest {

    @DisplayName("차 이름과 플레이할 라운드 횟수를 통해 레이싱 게임을 생성할 수 있다.")
    @Test
    void create_racing_game_test() {
        // given
        String carNames = "pobi,crong,honux";
        int roundToPlay = 5;

        // when & then
        assertDoesNotThrow(() -> new RacingGame(carNames, roundToPlay, new RandomNumberSelector()));
    }

    @DisplayName("게임에 할당된 모든 라운드가 종료되면 우승자를 확인할 수 있다.")
    @Test
    void check_winners_test() {
        // given
        String carNames = "pobi,crong,honux";
        int roundToPlay = 2;

        // when
        RacingGame racingGame = new RacingGame(carNames, roundToPlay, new MoveNumberSelector());
        for (int i = 0; i < roundToPlay; i++) {
            racingGame.proceedRound();
        }

        // then
        List<CarWinnerResponse> gameWinnersResult = racingGame.announceWinners();
        assertThat(gameWinnersResult.get(0).getCarName()).isEqualTo("pobi");
        assertThat(gameWinnersResult.get(1).getCarName()).isEqualTo("crong");
        assertThat(gameWinnersResult.get(2).getCarName()).isEqualTo("honux");
    }

    @DisplayName("게임이 종료되지 않았다면, 우승자를 가려낼 수 없다.")
    @Test
    void cannot_announce_winner_if_game_not_ended_test() {
        // given
        String carNames = "pobi,crong,honux";
        int roundToPlay = 2;
        RacingGame racingGame = new RacingGame(carNames, roundToPlay, new MoveNumberSelector());

        // when & then
        assertThatThrownBy(() -> racingGame.announceWinners())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("아직 게임이 종료되지 않았습니다.");
    }

    @DisplayName("게임이 진행중이라면, 진행중인 상태임을 확인할 수 있다.")
    @Test
    void is_game_playing_test() {
        // given
        String carNames = "pobi,crong,honux";
        int roundToPlay = 2;
        RacingGame racingGame = new RacingGame(carNames, roundToPlay, new MoveNumberSelector());

        // when & then
        boolean gamePlaying = racingGame.isGamePlaying();
        assertThat(gamePlaying).isTrue();
    }

    @DisplayName("게임이 종료되었다면, 종료된 상태임을 확인할 수 있다.")
    @Test
    void is_game_ended_test() {
        // given
        String carNames = "pobi,crong,honux";
        int roundToPlay = 2;

        // when
        RacingGame racingGame = new RacingGame(carNames, roundToPlay, new MoveNumberSelector());
        racingGame.proceedRound();
        racingGame.proceedRound();

        // then
        boolean gameEnded = racingGame.isGameEnded();
        assertThat(gameEnded).isTrue();
    }

    @DisplayName("게임의 라운드 진행 결과를 확인할 수 있다.")
    @Test
    void announce_round_result_test() {
        // given
        String carNames = "pobi,crong,honux";
        int roundToPlay = 2;
        RacingGame racingGame = new RacingGame(carNames, roundToPlay, new MoveNumberSelector());

        // when
        racingGame.proceedRound();
        racingGame.proceedRound();

        // then
        List<CarRoundResultResponse> secondRoundResult = racingGame.announceRoundResult();
        assertThat(secondRoundResult.get(0).getCarName()).isEqualTo("pobi");
        assertThat(secondRoundResult.get(0).getPosition()).isEqualTo(2);
        assertThat(secondRoundResult.get(1).getCarName()).isEqualTo("crong");
        assertThat(secondRoundResult.get(1).getPosition()).isEqualTo(2);
        assertThat(secondRoundResult.get(2).getCarName()).isEqualTo("honux");
        assertThat(secondRoundResult.get(2).getPosition()).isEqualTo(2);
    }
}

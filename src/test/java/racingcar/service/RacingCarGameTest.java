package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.dto.CarRequest;
import racingcar.service.dto.FinalResult;
import racingcar.service.dto.RoundResult;
import racingcar.utils.RacingCarConverter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    private List<CarRequest> inputCars;
    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        int round = 5;
        inputCars = List.of(new CarRequest("car1"), new CarRequest("car2"));
        racingCarGame = new RacingCarGame(RacingCarConverter.toCars(inputCars), round);
    }

    @Test
    @DisplayName("입력한 시도 횟수만큼 게임이 진행되면 게임이 종료된다.")
    void playGame() {
        while (!racingCarGame.isFinish()) {
            racingCarGame.doNextRound();
        }

        assertThat(racingCarGame.isFinish()).isTrue();
    }

    @Test
    @DisplayName("입력한 시도 횟수만큼 게임 진행 시 매 시도마다 결과가 반환된다.")
    void returnRoundResult() {
        while (!racingCarGame.isFinish()) {
            RoundResult roundResult = racingCarGame.doNextRound();

            assertThat(roundResult).isNotNull();
            assertThat(roundResult.toString()).isNotBlank();
        }
    }

    @Test
    @DisplayName("게임이 모두 완료되면 우승자가 선정된다.")
    void selectWinner() {
        while (!racingCarGame.isFinish()) {
            racingCarGame.doNextRound();
        }
        FinalResult finalResult = racingCarGame.selectWinners();

        assertThat(finalResult).isNotNull();
        assertThat(finalResult.toString()).isNotBlank();
    }

}

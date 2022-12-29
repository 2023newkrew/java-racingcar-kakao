package racingcar.controller;

import racingcar.controller.response.CarRoundResultResponse;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberSelector;
import racingcar.view.RacingGameView;

import java.util.List;

public class RacingGameController {

    private final RacingGameView racingGameView;
    private RacingGame racingGame;

    public RacingGameController() {
        this.racingGameView = new RacingGameView();
    }

    public void play() {
        initializeGame();
        racingGameView.printRoundResultMessage();
        while (racingGame.isGamePlaying()) {
            racingGame.proceedRound();
            List<CarRoundResultResponse> carRoundResults = racingGame.announceRoundResult();
            racingGameView.printRoundResult(carRoundResults);
        }
        announceWinner();
    }

    private void initializeGame() {
        try {
            String carNames = racingGameView.receiveCarNames();
            int roundToPlay = racingGameView.receiveRoundToPlay();
            racingGame = new RacingGame(carNames, roundToPlay, new RandomNumberSelector());
        } catch (IllegalArgumentException exception) {
            racingGameView.printExceptionMessage(exception.getMessage());
            initializeGame();
        }
    }

    private void announceWinner() {
        List<String> winners = racingGame.announceWinners();
        racingGameView.printWinners(winners);
    }
}

package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberSelector;
import racingcar.view.RacingGameView;

import java.util.List;
import java.util.Map;

public class RacingGameController {

    private final RacingGameView racingGameView;
    private RacingGame racingGame;

    public RacingGameController() {
        this.racingGameView = new RacingGameView();
    }

    public void play() {
        initializeGame();
        racingGameView.printRoundResultMessage();
        while (racingGame.checkWinners().isEmpty()) {
            racingGame.proceedGame();
            Map<String, Integer> roundResult = racingGame.announceRoundResult();
            racingGameView.printRoundResult(roundResult);
        }
        announceWinner();
    }

    private void initializeGame() {
        String carNames = racingGameView.receiveCarNames();
        int roundToPlay = racingGameView.receiveRoundToPlay();
        this.racingGame = new RacingGame(carNames, roundToPlay, new RandomNumberSelector(0, 10));
    }

    private void announceWinner() {
        List<String> winners = racingGame.checkWinners().get();
        racingGameView.printWinners(winners);
    }
}

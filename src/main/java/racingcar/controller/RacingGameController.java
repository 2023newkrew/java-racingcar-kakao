package racingcar.controller;

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
        racingGameView.printRoundResults(racingGame.operateRacingGame());
        announceWinner();
    }

    private void initializeGame() {
        String carNames = racingGameView.receiveCarNames();
        int roundToPlay = racingGameView.receiveRoundToPlay();
        this.racingGame = new RacingGame(carNames, roundToPlay, new RandomNumberSelector());
    }

    private void announceWinner() {
        if (racingGame.announceWinnersIfGameEnded().isPresent()) {
            List<String> winners = racingGame.announceWinnersIfGameEnded().get();
            racingGameView.printWinners(winners);
        }
    }
}

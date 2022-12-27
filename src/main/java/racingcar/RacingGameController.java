package racingcar;

public class RacingGameController {

    private IOView ioView;

    public RacingGameController() {
        this.ioView = new IOView();
    }

    public void start() {
        RacingGame racingGame = new RacingGame(ioView.inputCarNames(),ioView.inputFinalTurn());
        racingGame.playGame();
    }
}

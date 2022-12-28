package racingcar;

public class RacingGameController {

    private IO ioView;

    public RacingGameController() {
        this.ioView = new IO();
    }

    public void start() {
        RacingGame racingGame = new RacingGame(ioView.inputCarNames(),ioView.inputTurnIteration());
        racingGame.playGame();
    }
}

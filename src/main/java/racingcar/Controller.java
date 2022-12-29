package racingcar;

import racingcar.domain.Game;
import racingcar.domain.GameInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private Game game;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
        game = new Game();
    }

    public void playGame() {
        List<String> names = inputView.getNamesInput();
        int roundCnt = inputView.getRoundInput();
        inputView.close();

        GameInfo gameInfo = game.init(names, roundCnt);
        outputView.printInitialStatus(gameInfo);

        while (gameInfo.getLeftRoundCnt()!=0) {
            gameInfo = game.runRound();
            outputView.printRoundResult(gameInfo);
        }
        outputView.printGameResult(game.getWinners(gameInfo));
    }
}

package racingcar;

import racingcar.domain.Game;
import racingcar.domain.GameInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    private InputView inputView;
    private Game game;

    public Controller() {
        inputView = new InputView();
        game = new Game();
    }

    public void playGame() {
        List<String> names = inputView.getNamesInput();
        int roundCnt = inputView.getRoundInput();
        inputView.close();

        GameInfo gameInfo = game.init(names, roundCnt);
        OutputView.printInitialStatus(gameInfo);

        while (gameInfo.getLeftRoundCnt()!=0) {
            gameInfo = game.runRound();
            OutputView.printRoundResult(gameInfo);
        }
        OutputView.printGameResult(game.getWinners(gameInfo));
    }
}

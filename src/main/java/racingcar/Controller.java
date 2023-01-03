package racingcar;

import racingcar.domain.Game;
import racingcar.domain.GameInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final Game game;

    public Controller(InputView inputView, Game game) {
        this.inputView = inputView;
        this.game = game;
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

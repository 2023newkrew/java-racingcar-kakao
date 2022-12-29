package racingcar;

import racingcar.domain.Game;
import racingcar.domain.GameInfo;
import racingcar.view.IOHelper;

import java.util.List;

public class Controller {
    private IOHelper view;
    private Game game;

    public Controller() {
        view = new IOHelper();
        game = new Game();
    }

    public void playGame() {
        List<String> names = view.getNamesInput();
        int roundCnt = view.getRoundInput();

        GameInfo gameInfo = game.init(names, roundCnt);
        view.printInitialStatus(gameInfo);

        while (gameInfo.getLeftRoundCnt()!=0) {
            gameInfo = game.runRound();
            view.printRoundResult(gameInfo);
        }

        view.printGameResult(game.findWinners(gameInfo));
    }
}

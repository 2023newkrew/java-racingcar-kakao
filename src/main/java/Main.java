import racingcar.domain.Game;
import racingcar.dto.GameInfo;
import racingcar.view.IOHelper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        List<String> namesInput = IOHelper.getNamesInput();
        int roundInput = IOHelper.getRoundInput();

        GameInfo gameInfo = game.init(namesInput, roundInput);

        IOHelper.printInitialStatus(gameInfo);
        while(gameInfo.getLeftRoundCnt() != 0) {
            gameInfo = game.runRound();
            IOHelper.printCarStatus(gameInfo);
        }

        IOHelper.printGameResult(game.findWinners(gameInfo));
    }
}

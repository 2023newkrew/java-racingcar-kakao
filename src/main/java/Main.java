import racingcar.domain.Game;
import racingcar.dto.GameInfo;
import racingcar.view.IOHelper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IOHelper ioHelper = new IOHelper();

        Game game = new Game();

        List<String> namesInput = ioHelper.getNamesInput();
        int roundInput = ioHelper.getRoundInput();

        GameInfo gameInfo = game.init(namesInput, roundInput);

        ioHelper.printInitialStatus(gameInfo);
        while(gameInfo.getLeftRoundCnt() != 0) {
            gameInfo = game.runRound();
            ioHelper.printRoundResult(gameInfo);
        }

        ioHelper.printGameResult(game.findWinners(gameInfo));
    }
}

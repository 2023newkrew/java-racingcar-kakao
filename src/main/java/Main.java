import racingcar.domain.Game;
import racingcar.domain.RamdomMovable;
import racingcar.dto.GameInfo;
import racingcar.view.BasicValidator;
import racingcar.view.IOHelper;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        IOHelper ioHelper = new IOHelper(new BasicValidator());

        GameInfo gameInfo = game.init(ioHelper.getNamesInput(), ioHelper.getRoundInput(), new RamdomMovable());

        ioHelper.printInitialStatus(gameInfo);
        while (gameInfo.getLeftRoundCnt() != 0) {
            gameInfo = game.runRound();
            ioHelper.printCarStatus(gameInfo);
        }
        ioHelper.printGameResult(game.findWinners(gameInfo));
        ioHelper.close();
    }
}

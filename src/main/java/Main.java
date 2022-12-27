import racingcar.Game;
import racingcar.IOHelper;

public class Main {
    public static void main(String[] args) {
        IOHelper ioHelper = new IOHelper();

        Game game = new Game();
        game.run(ioHelper);

        ioHelper.close();
    }
}

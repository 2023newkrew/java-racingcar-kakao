package racingcar;

import racingcar.model.Race;
import racingcar.view.Input;
import racingcar.view.Output;

import java.io.IOException;

public class Controller {
    public static void main(String[] args) throws IOException {
        String nameString = Input.nameStringInput();
        int turn = Input.turnInput();

        Race race = new Race(nameString, turn);

        Output.printNoticeResult();
        Output.printRaceStatus(race);
        while(!race.isEnd()) {
            race.playTurn();
            Output.printRaceStatus(race);
        }

        Output.printRaceWinner(race);
    }
}

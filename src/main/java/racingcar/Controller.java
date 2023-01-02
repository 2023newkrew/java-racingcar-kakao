package racingcar;

import racingcar.model.NameStringVerify;
import racingcar.model.Race;
import racingcar.model.TurnVerify;
import racingcar.view.Input;
import racingcar.view.Output;

import java.io.IOException;

public class Controller {
    public static void main(String[] args) throws IOException {
        String nameString = Input.nameStringInput();
        NameStringVerify.verifyNameString(nameString);

        int turn = Input.turnInput();
        TurnVerify.verifyTurn(turn);

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

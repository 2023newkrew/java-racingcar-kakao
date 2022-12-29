package racingcar.step2.view;

import org.junit.jupiter.api.Test;
import racingcar.step2.domain.RacingGame;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RacingOutputViewTest {

    @Test
    void 자동차_이름과_전진횟수_출력(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        RacingGame racingGame = new RacingGame("pobi,crong,honux");
        RacingOutputView racingOutputView = new RacingOutputView();
        racingOutputView.printCars(racingGame.getCars());

        String actual = out.toString();

        String expect = "pobi : -\n" +
                "crong : -\n" +
                "honux : -\n\n";

        assertEquals(actual, expect);
    }

}
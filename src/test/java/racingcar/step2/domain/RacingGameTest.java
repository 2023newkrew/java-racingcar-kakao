package racingcar.step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void 입력받은_자동차_이름들을_쉼표_구분자로_구분(){
        RacingGame racingGame = new RacingGame();
        assertTrue(Arrays.deepEquals(racingGame.NameCsvToArray("pobi,crong,honux")
                ,(new String[]{"pobi", "crong", "honux"})));
    }

}
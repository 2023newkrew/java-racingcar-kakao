package racingcar.step2.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void 입력받은_이름으로_자동차_객체_생성() throws CloneNotSupportedException {
        assertEquals(new RacingGame("pobi,crong,honux").getCars().size(),3);
    }

}
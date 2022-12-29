package racingcar.step2.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void 입력받은_이름으로_자동차_객체_생성(){
        assertEquals(new RacingGame("pobi,crong,honux").getCars().size(),3);
    }

    @Test
    void 최대_전진_거리_판별(){
        RacingGame racingGame = new RacingGame("pobi,crong,honux");
        racingGame.getCars().get(0).move(4);
        racingGame.getCars().get(0).move(4);
        racingGame.getCars().get(0).move(4);

        assertEquals(racingGame.getMaxPosition(),4);
    }

}
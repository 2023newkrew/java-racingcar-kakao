package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class RacingGameTest {

    @Test
    @DisplayName("한 턴을 플레이하는 기능")
    public void playTurn() {
        //given
        RacingGame racingGame = new RacingGame(List.of("abc","efg","hijkl"),5);

        //when
        racingGame.proceedTurn();
        racingGame.proceedTurn();

        //then
        assertEquals(2,racingGame.getTurnCount());
    }
}

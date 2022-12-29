package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;

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

    @Test
    @DisplayName("주어진 수 만큼 턴을 반복하는 기능")
    public void repeatPlayingTurn() {
        //given
        RacingGame racingGame = new RacingGame(List.of("abc","efg","hijkl"),5);

        //when
        while(!racingGame.isFinished()) {
            racingGame.proceedTurn();
        }

        //then
        assertEquals(5,racingGame.getTurnCount());
    }

    @Test
    @DisplayName("게임 종료 후 우승자들을 판별해서 반환하는 기능")
    public void judgeWinners() {
        //given
        RacingGame racingGame = new RacingGame(List.of("abc","efg","hijkl"),5);

        //when
        while(!racingGame.isFinished()) {
            racingGame.proceedTurn();
        }

        List<RacingCar> winners = racingGame.judgeWinners();

        // then
        // 위너끼리 pos가 같은지 확인
        int winnerPos = winners.get(0).getPos();
        for(RacingCar rc : winners) {
            assertEquals(winnerPos, rc.getPos());
        }

        // 위너가 아닌 차들의 pos가 위너의 pos보다 작은지 확인
        for(RacingCar rc : racingGame.getCars()) {
            if(winners.contains(rc)) continue;
            assertTrue(rc.getPos() < winnerPos);
        }
    }
}

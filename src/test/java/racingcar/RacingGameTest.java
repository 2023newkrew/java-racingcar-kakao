package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.RacingCar;
import racingcar.domain.game.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {

    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        //given
        racingGame = new RacingGame(List.of("abc", "efg", "hijkl"), 5);
    }

    @Test
    @DisplayName("한 턴을 플레이하는 기능")
    public void playTurn() {
        //when
        racingGame.proceedTurn();
        racingGame.proceedTurn();

        //then
        assertEquals(2, racingGame.getTurnInfo().getTurnCount());
    }

    @Test
    @DisplayName("주어진 수 만큼 턴을 반복하는 기능")
    public void repeatPlayingTurn() {
        //when
        while (!racingGame.getTurnInfo().isFinished()) {
            racingGame.proceedTurn();
        }

        //then
        assertEquals(5, racingGame.getTurnInfo().getTurnCount());
    }

    @Test
    @DisplayName("가장 멀리 이동한 우승자들을 판별해서 반환하는 기능")
    public void judgeWinners() {
        //when
        racingGame.getCars().get(0).move(()->1);
        racingGame.getCars().get(1).move(()->4);
        racingGame.getCars().get(1).move(()->5);
        racingGame.getCars().get(2).move(()->9);
        racingGame.getCars().get(2).move(()->7);

        List<RacingCar> judgedWinners = racingGame.judgeWinners();

        // then
        assertTrue(judgedWinners.containsAll(racingGame.getCars().subList(1,3)));
    }
}

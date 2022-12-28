package car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class GameRuleTest {

    Integer[] carPositions;
    ArrayList<RacingPlayer> players;

    @BeforeEach
    void init() {
        players = new ArrayList<>();
        carPositions = new Integer[] {
                0, 1, 2, 3, 4, 5, 5, 5
        };

        for(int i = 0; i < carPositions.length ; i++) {
            Car newCar = new Car("testPlayer" + String.valueOf(i));
            setPlayerPosition(newCar, carPositions[i]);
            players.add(newCar);
        }
    }

    private void setPlayerPosition(RacingPlayer player, int position) {
        for (int i = 0; i < position; i++) {
            player.proceedNextTurn(true);
        }
    }

    @Test
    void getWinnersTest() {
        RacingPlayer[] result = GameRule.getWinners(players);
        Assertions.assertThat(result).isEqualTo(players.subList(5, 8).toArray());
    }

}
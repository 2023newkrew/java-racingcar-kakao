package mvc.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    @Test
    @DisplayName("가장 멀리 이동한 자동차 위치 추출")
    void extractWinnerScore() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("one", 1));
        carList.add(new Car("two", 2));
        carList.add(new Car("three", 3));

        Game game = new Game(carList, 5);
        assertThat(game.extractWinnerScore()).isEqualTo(3);
    }
}
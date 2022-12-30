package mvc.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("one", 1));
        carList.add(new Car("two", 2));
        carList.add(new Car("three", 3));

        game = new Game(carList, 5);
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차 위치 추출")
    void extractWinnerScore() {
        assertThat(game.extractWinnerPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자 리스트 생성")
    void winners() {
        assertThat(game.findWinners().get(0)).isEqualTo(new Car("three", 3));
    }
}
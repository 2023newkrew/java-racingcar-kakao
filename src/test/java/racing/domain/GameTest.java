package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
public class GameTest {
    private Game game;
    private int initialGameTurn = 5;

    @BeforeEach
    void init() {
        game = new Game("car1,car2,car3", initialGameTurn);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0})
    void 게임_진행_횟수는_양수여야_한다(int gameTurn) {
        assertThatThrownBy(() -> new Game("car1, car2", gameTurn))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임을_한번_플레이하면_진행횟수가_1_줄어든다() {
        game.play();
        assertThat(game.gameTurn()).isEqualTo(initialGameTurn - 1);
    }

    @Test
    void 게임을_진행횟수만큼_플레이하면_게임_종료표시가_true가_된다() {
        IntStream.rangeClosed(1, initialGameTurn).forEach((i) -> game.play());
        assertThat(game.isEnd()).isTrue();
    }
}

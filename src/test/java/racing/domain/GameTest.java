package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @ParameterizedTest
    @MethodSource("decideWinnerArgument")
    @DisplayName("가장 높은 위치를 가진 자동차가 우승하며, 공동 우승이 존재할 수 있다.")
    public void decideWinner(Game game, List<String> expected) {
        assertThat(game.getWinnerNames()).isEqualTo(expected);
    }

    static Stream<Arguments> decideWinnerArgument() {
        Car winner1 = new Car("noah", 4);
        Car winner2 = new Car("go", 4);
        Car winner3 = new Car("mars", 4);
        Car loser1 = new Car("java", 2);
        Car loser2 = new Car("xx", 3);

        Game game1 = new Game(new Cars(Arrays.asList(winner1, loser1, loser2)));
        Game game2 = new Game(new Cars(Arrays.asList(winner1, winner2, loser2)));
        Game game3 = new Game(new Cars(Arrays.asList(winner1, winner2, winner3)));

        return Stream.of(
                Arguments.arguments(game1, Arrays.asList(winner1.getName())),
                Arguments.arguments(game2, Arrays.asList(winner1.getName(), winner2.getName())),
                Arguments.arguments(game3, Arrays.asList(winner1.getName(), winner2.getName(), winner3.getName()))
        );
    }
}

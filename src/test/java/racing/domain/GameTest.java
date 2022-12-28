package racing.domain;

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
    public void decideWinner(Game game, List<Car> expected) {
        assertThat(game.decideWinners()).isEqualTo(expected);
    }

    static Stream<Arguments> decideWinnerArgument() {
        Car winner1 = new Car("noah", 4);
        Car winner2 = new Car("go", 4);
        Car loser1 = new Car("java", 2);
        Car loser2 = new Car("go", 3);

        return Stream.of(
                Arguments.arguments(
                        new Game(new Cars(Arrays.asList(winner1, loser1, loser2))),
                        Arrays.asList(winner1.getName())
                ),
                Arguments.arguments(
                        new Game(new Cars(Arrays.asList(winner1, winner2, loser2))),
                        Arrays.asList(winner1.getName(), winner2.getName())
                )
        );
    }
}

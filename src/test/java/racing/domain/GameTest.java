package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @ParameterizedTest
    @ValueSource(strings = {"user1,user2,user3,user4", "user1,user2,user3"})
    void 쉼표로_구분된_유저의_명수만큼_자동차들이_만들어집니다(String input){
        // when
        Game game = new Game();

        // given
        game.initialize(input);

        // then
        assertThat(game.getStatus().size()).isEqualTo(input.split(",").length);
    }

    @ParameterizedTest
    @MethodSource("decideWinnerArgument")
    public void 한명_이상의_유저들이_승리했을때_정상적으로_판별합니다(Game game, List<Car> expected) {
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

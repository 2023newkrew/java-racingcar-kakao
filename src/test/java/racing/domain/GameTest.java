package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GameTest {


    @Test
    void 문자열_리스트로_생성할_수_있다() {
        String[] names = {"user1", "user2"};
        assertDoesNotThrow(() -> new Game(names));
    }
    @Test
    void 유저의_이름_갯수만큼_자동차들이_만들어진다(){
        // when
        String[] names = {"user1", "user2", "user3", "user4"};
        Game game = new Game(names);

        // given & then
        assertThat(game.getCars().size()).isEqualTo(names.length);
    }

    @ParameterizedTest
    @MethodSource("decideWinnerArgument")
    void 한명_이상의_유저들이_승리했을때_정상적으로_판별한(Game game, List<Car> expected) {
        assertThat(game.getWinnerNames()).isEqualTo(expected);
    }

    static Stream<Arguments> decideWinnerArgument() {
        Car winner1 = new RacingCar("noah", 4);
        Car winner2 = new RacingCar("go", 4);
        Car loser1 = new RacingCar("java", 2);
        Car loser2 = new RacingCar("go", 3);
        new Game(new Cars(Arrays.asList(winner1, loser1, loser2)));
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

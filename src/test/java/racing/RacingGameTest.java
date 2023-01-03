package racing;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @ParameterizedTest
    @MethodSource("getCreateData")
    void createRacingGame(String names, String expected) {
        RacingGame racingGame = new RacingGame(names, 0, new Random());
        assertThat(racingGame.toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> getCreateData() {
        return Stream.of(
                Arguments.of("1234", "1234 : -"),
                Arguments.of("1,2", "1 : -\n2 : -"),
                Arguments.of("1,2,A", "1 : -\n2 : -\nA : -")
        );
    }

    @ParameterizedTest
    @MethodSource("getRaceData")
    void race(String names, List<Integer> randomNumbers, String expected) {
        RacingGame simulator = new RacingGame(names, 1, createRandom(randomNumbers));
        simulator.race();
        assertThat(simulator.toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> getRaceData() {
        return Stream.of(
                Arguments.of("A,B,C", List.of(4, 3, 2), "A : --\nB : -\nC : -"),
                Arguments.of("D,E,F", List.of(1, 5, 6), "D : -\nE : --\nF : --"),
                Arguments.of("1,2,3", List.of(8, 3, 5), "1 : --\n2 : -\n3 : --"),
                Arguments.of("4,5,6", List.of(9, 9, 9), "4 : --\n5 : --\n6 : --")
        );
    }

    @ParameterizedTest
    @MethodSource("getRunManyTimesData")
    void runManyTimes(String names, int times, List<Integer> randomNumbers, String expected) {
        RacingGame racingGame = new RacingGame(names, times, createRandom(randomNumbers));
        while(racingGame.isEnd()) {
            racingGame.race();
        }
        assertThat(racingGame.toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> getRunManyTimesData() {
        return Stream.of(
                Arguments.of("A,B", 2, List.of(4, 3, 5, 2), "A : ---\nB : -"),
                Arguments.of("D,E", 3, List.of(9, 2, 6, 5, 1, 2), "D : ---\nE : --")
        );
    }

    @ParameterizedTest
    @MethodSource("getWinnersData")
    void getWinners(String carNames, int tryNo, List<Integer> randomNumbers, String expected) {
        RacingGame racingGame = new RacingGame(carNames, tryNo, createRandom(randomNumbers));
        while(racingGame.isEnd()) {
            racingGame.race();
        }
        assertThat(racingGame.getWinners()).isEqualTo(expected);
    }

    private static Stream<Arguments> getWinnersData() {
        return Stream.of(
                Arguments.of("A,B", 2, List.of(4, 3, 5, 2), "A"),
                Arguments.of("D,E", 3, List.of(9, 2, 6, 5, 1, 4), "D, E")
        );
    }

    private Random createRandom(List<Integer> randomNumbers) {
        return new Random() {
            int index = 0;
            public int nextInt(int bound) {
                return randomNumbers.get(index++);
            }
        };
    }
}

package racing;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SimulatorTest {
    @ParameterizedTest
    @MethodSource("getCreateData")
    void create(String input, String expected) {
        Simulator simulator = new Simulator();
        simulator.create(input);
        assertThat(simulator.toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> getCreateData() {
        return Stream.of(
                Arguments.of("1234", "1234 : -"),
                Arguments.of("1,2", "1 : -\n2 : -"),
                Arguments.of("1,2,A", "1 : -\n2 : -\nA : -")
        );
    }

    @ParameterizedTest
    @MethodSource("getRunData")
    void run(String names, List<Integer> randoms, String expected) {
        Simulator simulator = new Simulator();
        simulator.create(names);
        simulator.run(createRandoms(randoms));
        assertThat(simulator.toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> getRunData() {
        return Stream.of(
                Arguments.of("A,B,C", List.of(4, 3, 2), "A : --\nB : -\nC : -"),
                Arguments.of("D,E,F", List.of(1, 5, 6), "D : -\nE : --\nF : --"),
                Arguments.of("1,2,3", List.of(8, 3, 5), "1 : --\n2 : -\n3 : --"),
                Arguments.of("4,5,6", List.of(9, 9, 9), "4 : --\n5 : --\n6 : --")
        );
    }

    private Random createRandoms(List<Integer> returnValue) {
        return new Random() {
            int index = 0;
            public int nextInt(int bound) {
                return returnValue.get(index++);
            }
        };
    }

    @ParameterizedTest
    @MethodSource("getSimulateData")
    void runManyTimes(String names, List<Integer> randoms, int times, String expected) {
        Simulator simulator = new Simulator();
        simulator.create(names);
        for (int i = 0; i < times; i++) {
            simulator.run(createRandoms(randoms));
        }
        assertThat(simulator.toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> getSimulateData() {
        return Stream.of(
                Arguments.of("A,B", List.of(4, 3, 5, 2), 2, "A : ---\nB : -"),
                Arguments.of("D,E", List.of(9, 2, 6, 5, 1, 2), 3, "D : ---\nE : --")
        );
    }

    @ParameterizedTest
    @MethodSource("getWinnersData")
    void winners(String names, List<Integer> randoms, int times, String winners) {
        Simulator simulator = new Simulator();
        simulator.create(names);
        for (int i = 0; i < times; i++) {
            simulator.run(createRandoms(randoms));
        }
        assertThat(simulator.winners()).isEqualTo(winners);
    }

    private static Stream<Arguments> getWinnersData() {
        return Stream.of(
                Arguments.of("A,B", List.of(4, 3, 5, 2), 2, "A"),
                Arguments.of("D,E", List.of(9, 2, 6, 5, 1, 4), 3, "D, E")
        );
    }
}

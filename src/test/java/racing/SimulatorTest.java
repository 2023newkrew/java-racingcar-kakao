package racing;

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
}

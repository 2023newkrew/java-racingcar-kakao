package stringcalculator;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @ParameterizedTest
    @MethodSource("generateData")
    void split(String input, String[] expected) {
        StringCalculator calculator = new StringCalculator();
        String[] result = calculator.split(input);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("", new String[]{}),
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1,2,3", new String[]{"1", "2", "3"}),
                Arguments.of("1,2:3", new String[]{"1", "2", "3"})
        );
    }
}

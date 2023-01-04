package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;

public class StringCalculatorTest {
    @ParameterizedTest
    @MethodSource("generateSplitData")
    void split(String input, String[] expected) {
        StringCalculator calculator = new StringCalculator();
        String[] result = calculator.split(input);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generateSplitData() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1,2,3", new String[]{"1", "2", "3"}),
                Arguments.of("1,2:3", new String[]{"1", "2", "3"}),
                Arguments.of("//;\n1;2;3", new String[]{"1", "2", "3"}),
                Arguments.of("//-\n1-2", new String[]{"1", "2"})
        );
    }

    @ParameterizedTest
    @MethodSource("generateSumData")
    void sum(int[] input, int expected) {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.sum(input);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generateSumData() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1, 2}, 3),
                Arguments.of(new int[]{1, 2, 3}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("generateCastData")
    void cast(String[] input, int[] expected) {
        StringCalculator calculator = new StringCalculator();
        int[] result = calculator.cast(input);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generateCastData() {
        return Stream.of(
                Arguments.of(new String[]{}, new int[]{}),
                Arguments.of(new String[]{"1", "2"}, new int[]{1, 2}),
                Arguments.of(new String[]{"1", "2", "3"}, new int[]{1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("generateHasNegativeData")
    void hasNegative(int[] input, boolean expected) {
        StringCalculator calculator = new StringCalculator();
        boolean result = calculator.hasNegative(input);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generateHasNegativeData() {
        return Stream.of(
                Arguments.of(new int[]{}, false),
                Arguments.of(new int[]{1, 2}, false),
                Arguments.of(new int[]{1, 2, -3}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("generatedCalculateData")
    void calculate(String s, int expected) {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(s);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generatedCalculateData() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("1", 1),
                Arguments.of("1,2", 3),
                Arguments.of("1,2,3", 6),
                Arguments.of("1,2:3", 6),
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//-\n1-2", 3),
                Arguments.of("//^\n1^2", 3),
                Arguments.of("//\\\n1\\2", 3)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "a", "a,1"})
    void splitWrong(String input) {
        StringCalculator calculator = new StringCalculator();
        assertThatRuntimeException().isThrownBy(() -> calculator.calculate(input));
    }
}

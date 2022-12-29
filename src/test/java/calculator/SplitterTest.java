package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SplitterTest {

    @ParameterizedTest
    @MethodSource("generator1")
    void givenCommaString_thenReturnArrayList(String input, List<Integer> expected){
        Splitter splitter = new Splitter();
        List<Integer> result = splitter.split(input);

        assertThat(result).isEqualTo(expected);
    }
    private static Stream<Arguments> generator1(){
        return Stream.of(
                Arguments.of("1,2,3", Arrays.asList(1,2,3)),
                Arguments.of("2,3", Arrays.asList(2,3)),
                Arguments.of("   2,3    ", Arrays.asList(2,3)),
                Arguments.of("  2 ,   3 ", Arrays.asList(2,3))
        );
    }

    @ParameterizedTest
    @MethodSource("generator2")
    void givenCommaAndSemiColonString_thenReturnArrayList(String input, List<Integer> expected){
        Splitter splitter = new Splitter();
        List<Integer> result = splitter.split(input);

        assertThat(result).isEqualTo(expected);
    }
    private static Stream<Arguments> generator2(){
        return Stream.of(
                Arguments.of("1,2;3", Arrays.asList(1,2,3)),
                Arguments.of("2;3;4", Arrays.asList(2,3,4))
        );
    }

    @ParameterizedTest
    @MethodSource("generator3")
    void givenCustomDelimiter_thenReturnList(String input, List<Integer> expected){
        Splitter splitter = new Splitter();
        List<Integer> result = splitter.split(input);

        assertThat(result).isEqualTo(expected);
    }
    private static Stream<Arguments> generator3(){
        return Stream.of(
                Arguments.of("//^$\n4$5^6,7", Arrays.asList(4,5,6,7)),
                Arguments.of("//*\n1*2*3", Arrays.asList(1,2,3))
                );
    }
}

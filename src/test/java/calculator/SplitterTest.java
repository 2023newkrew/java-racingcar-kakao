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
    @MethodSource("stringWithCommaDelimiterGenerator")
    void 컴마로만_구분된_문자열_입력시_정수리스트_반환(String input, List<Integer> expected){
        Splitter splitter = new Splitter();
        List<Integer> result = splitter.split(input);

        assertThat(result).isEqualTo(expected);
    }
    private static Stream<Arguments> stringWithCommaDelimiterGenerator(){
        return Stream.of(
                Arguments.of("1,2,3", Arrays.asList(1,2,3)),
                Arguments.of("2,3", Arrays.asList(2,3)),
                Arguments.of("   2,3    ", Arrays.asList(2,3)),
                Arguments.of("  2 ,   3 ", Arrays.asList(2,3))
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithCommaAndSemiColonDelimiterGenerator")
    void 컴마_및_세미콜론으로_구분된_문자열입력시_정수리스트_반환(String input, List<Integer> expected){
        Splitter splitter = new Splitter();
        List<Integer> result = splitter.split(input);

        assertThat(result).isEqualTo(expected);
    }
    private static Stream<Arguments> stringWithCommaAndSemiColonDelimiterGenerator(){
        return Stream.of(
                Arguments.of("1,2;3", Arrays.asList(1,2,3)),
                Arguments.of("2;3;4", Arrays.asList(2,3,4))
        );
    }

    @ParameterizedTest
    @MethodSource("stringWithCustomDelimiterGenerator")
    void 커스텀구분자가_사용된_문자열입력시_정수리스트_반환(String input, List<Integer> expected){
        Splitter splitter = new Splitter();
        List<Integer> result = splitter.split(input);

        assertThat(result).isEqualTo(expected);
    }
    private static Stream<Arguments> stringWithCustomDelimiterGenerator(){
        return Stream.of(
                Arguments.of("//^$\n4$5^6,7", Arrays.asList(4,5,6,7)),
                Arguments.of("//*\n1*2*3", Arrays.asList(1,2,3))
                );
    }
}

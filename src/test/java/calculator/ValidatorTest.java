package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    @ParameterizedTest
    @MethodSource("generator")
    void givenNegativeNumber_thenThrowException(List<Integer> numbers){
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.hasNegative(numbers))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> generator(){
        return Stream.of(
                Arguments.of(Arrays.asList(1,-2)),
                Arguments.of(Arrays.asList(-1,2)),
                Arguments.of(Arrays.asList(-1,2,3))
        );
    }
}

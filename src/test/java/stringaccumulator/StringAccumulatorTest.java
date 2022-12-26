package stringaccumulator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAccumulatorTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class from {
        @ParameterizedTest
        @MethodSource
        void should_returnStringAccumulator_when_validString(String input, String separator, String content) {
            StringAccumulator accumulator = StringAccumulator.from(input);
            assertThat(accumulator.equalsTo(separator, content)).isTrue();
        }

        Stream<Arguments> should_returnStringAccumulator_when_validString() {
            return Stream.of(
                    Arguments.of("//.\n123", "//.\n", "123"),
                    Arguments.of("//\n//\n", "//\n", "//\n"),
                    Arguments.of("////\n\n", "////\n", "\n")
            );
        }

        @Test
        void should_throwException_when_newlineNotExists() {
            assertThatThrownBy(() -> {
                StringAccumulator.from("//.\123");
            }).isInstanceOf(RuntimeException.class);
        }
    }
}
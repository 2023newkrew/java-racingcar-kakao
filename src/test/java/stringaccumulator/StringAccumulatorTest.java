package stringaccumulator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static stringaccumulator.StringSplitter.PREFIX;
import static stringaccumulator.StringSplitter.SUFFIX;

class StringAccumulatorTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class from {
        @ParameterizedTest
        @MethodSource
        void should_returnStringAccumulator_when_validString(String input, StringAccumulator expectedAccumulator) {
            StringAccumulator accumulator = StringAccumulator.from(input);
            assertThat(accumulator).isEqualTo(expectedAccumulator);
        }

        Stream<Arguments> should_returnStringAccumulator_when_validString() {
            return Stream.of(
                    Arguments.of("//.\n123", new StringAccumulator("//.\n", "123", StringSplitter.from("//.\n"))),
                    Arguments.of("//\n//\n", new StringAccumulator("//\n", "//\n", StringSplitter.from("//\n"))),
                    Arguments.of("////\n\n", new StringAccumulator("////\n", "\n", StringSplitter.from("////\n")))
            );
        }

        @Test
        void should_throwException_when_newlineNotExists() {
            assertThatThrownBy(() -> {
                StringAccumulator.from("//.\123");
            }).isInstanceOf(RuntimeException.class);
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class accumulate {
        @ParameterizedTest
        @MethodSource
        void should_returnSumOfTokens_when_validTokens(StringAccumulator accumulator, int expected) {
            long result = accumulator.accumulate();
            assertThat(result).isEqualTo(expected);
        }

        Stream<Arguments> should_returnSumOfTokens_when_validTokens() {
            return Stream.of(
                    Arguments.of(StringAccumulator.from(String.join(",", List.of(""))), 0),
                    Arguments.of(StringAccumulator.from(String.join(",", List.of("1", "2", "3"))), 6),
                    Arguments.of(StringAccumulator.from(String.join(",", List.of("1", " 2", " 3"))), 6),
                    Arguments.of(StringAccumulator.from(String.join(",", List.of("1", "2 ", "3 "))), 6),
                    Arguments.of(StringAccumulator.from(String.join(",", List.of("1", "", "2", "3"))), 6)
            );
        }

        @ParameterizedTest
        @MethodSource
        void should_throwException_when_invalidTokens(StringAccumulator accumulator) {
            assertThatThrownBy(accumulator::accumulate)
                    .isInstanceOf(RuntimeException.class);
        }

        Stream<Arguments> should_throwException_when_invalidTokens() {
            return Stream.of(
                    Arguments.of(StringAccumulator.from(String.join(",", List.of("-1", "1")))),
                    Arguments.of(StringAccumulator.from(String.join(",", List.of("1 2", "3")))),
                    Arguments.of(StringAccumulator.from(String.join(",", List.of("asd")))),
                    Arguments.of(StringAccumulator.from(String.join(",", List.of(String.valueOf(Long.MAX_VALUE)) + "123")))
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class parseContentBySeparator {
        @ParameterizedTest
        @MethodSource
        void should_returnSplitTokens_when_validSeparator(String separator, String content, List<String> expected) {
            List<String> result = StringAccumulator.parseContentBySplitter(StringSplitter.from(separator), content);
            assertThatList(result).isEqualTo(expected);
        }

        Stream<Arguments> should_returnSplitTokens_when_validSeparator() {
            return Stream.of(
                    Arguments.of(PREFIX + "." + SUFFIX, String.join(".", List.of("1", "2", "3")), List.of("1", "2", "3")),
                    Arguments.of(PREFIX + "$" + SUFFIX, String.join("$", List.of("1", " 2", " 3")), List.of("1", "2", "3")),
                    Arguments.of(PREFIX + "|" + SUFFIX, String.join("|", List.of("1", "2 ", "3 ")), List.of("1", "2", "3")),
                    Arguments.of(PREFIX + "?" + SUFFIX, String.join("?", List.of("1", " ", "2", "3")), List.of("1", "2", "3"))
            );
        }
    }
}
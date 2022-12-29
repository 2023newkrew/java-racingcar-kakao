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
import static org.junit.jupiter.api.Assertions.*;

class SeparatorParserTest {

    @Nested
    class from {

        @Test
        void should_throwException_when_givenInvalidString() {
            assertThatThrownBy(() -> {
                SeparatorParser.from("//.\123");
            }).isInstanceOf(RuntimeException.class).hasMessage("Invalid string.");
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class parseSeparator {

        @ParameterizedTest
        @MethodSource
        void should_returnSeparator_when_givenInput(String input, String separator) {
            SeparatorParser separatorParser = SeparatorParser.from(input);
            assertThat(separatorParser.parseSeparator()).isEqualTo(separator);
        }

        Stream<Arguments> should_returnSeparator_when_givenInput() {
            return Stream.of(
                    Arguments.of("//\n//\n", ""),
                    Arguments.of("//.\n123", "."),
                    Arguments.of("//.\n", "."),
                    Arguments.of("//. \n", ". "),
                    Arguments.of("//.\n\n", "."),
                    Arguments.of("//123\n", "123"),
                    Arguments.of("////\n\n", "//"),
                    Arguments.of("123", "")
            );
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class parseContent {

        @ParameterizedTest
        @MethodSource
        void should_returnContent_when_givenInput(String input, String content) {
            SeparatorParser separatorParser = SeparatorParser.from(input);
            assertThat(separatorParser.parseContent()).isEqualTo(content);
        }

        Stream<Arguments> should_returnContent_when_givenInput() {
            return Stream.of(
                    Arguments.of("//.\n123", "123"),
                    Arguments.of("//\n//\n", "//\n"),
                    Arguments.of("//.\n", ""),
                    Arguments.of("123", "123"),
                    Arguments.of("////\n\n", "\n")
            );
        }
    }
}
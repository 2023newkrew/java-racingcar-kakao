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

class StringSplitterTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class from {
        @ParameterizedTest
        @MethodSource
        void should_returnStringSplitter_when_validString(String input, String customSeparator) {
            StringSplitter splitter = StringSplitter.from(input);
            assertThat(splitter.contains(customSeparator)).isTrue();
        }

        Stream<Arguments> should_returnStringSplitter_when_validString() {
            return Stream.of(
                    Arguments.of("//.\n", "."),
                    Arguments.of("//. \n", ". "),
                    Arguments.of("///.\n", "/."),
                    Arguments.of("//.\n\n", ".\n"),
                    Arguments.of("//123\n", "123")
            );
        }

        @Test
        void should_throwException_when_invalidPrefix() {
            assertThatThrownBy(() -> {
                StringSplitter.from("/.\n");
            }).isInstanceOf(RuntimeException.class);
        }

        @Test
        void should_throwException_when_invalidSuffix() {
            assertThatThrownBy(() -> {
                StringSplitter.from("//.\\");
            }).isInstanceOf(RuntimeException.class);
        }

        @Test
        void should_hasNotEmptyString_when_givenEmptySeparator() {
            StringSplitter splitter = StringSplitter.from("//\n");
            assertThat(splitter.contains("")).isFalse();
        }
    }
}
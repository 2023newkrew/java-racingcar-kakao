package stringaccumulator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

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

        @Nested
        class should_throwException {
            @ParameterizedTest
            @ValueSource(strings = {"/.\n", "", " "})
            void when_invalidPrefix(String input) {
                assertThatThrownBy(() -> {
                    StringSplitter.from(input);
                }).isInstanceOf(RuntimeException.class);
            }

            @Test
            void when_invalidSuffix() {
                assertThatThrownBy(() -> {
                    StringSplitter.from("//.\\");
                }).isInstanceOf(RuntimeException.class);
            }
        }

        @Nested
        class should_has_NotEmptyString {
            @Test
            void when_givenEmptySeparator() {
                StringSplitter splitter = StringSplitter.from("//\n");
                assertThat(splitter.contains("")).isFalse();
            }

            @Test
            void when_givenNull() {
                StringSplitter splitter = StringSplitter.from(null);
                assertThat(splitter.contains("")).isFalse();
            }
        }

        @Test
        void should_hasNotEmptyString_when_givenEmptySeparator() {
            StringSplitter splitter = StringSplitter.from("//\n");
            assertThat(splitter.contains("")).isFalse();
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class split {
        @ParameterizedTest
        @MethodSource
        void should_returnTokens_when_givenSplitter(StringSplitter splitter, String content, List<String> tokens) {
            List<String> result = splitter.split(content);
            assertThatList(result).isEqualTo(tokens);
        }

        Stream<Arguments> should_returnTokens_when_givenSplitter() {
            StringSplitter nullSplitter = StringSplitter.from(null);
            StringSplitter blank1Splitter = StringSplitter.from("// \n");
            StringSplitter blank2Splitter = StringSplitter.from("//  \n");
            StringSplitter splitter = StringSplitter.from("//11\n");
            return Stream.of(
                    Arguments.of(nullSplitter, "", List.of("")),
                    Arguments.of(nullSplitter, "1,2,3", List.of("1", "2", "3")),
                    Arguments.of(nullSplitter, "1, 2, 3", List.of("1", " 2", " 3")),
                    Arguments.of(blank1Splitter, "1, 2, 3", List.of("1", "", "2", "", "3")),
                    Arguments.of(blank2Splitter, "1,  2, 3", List.of("1", "", "2", " 3")),
                    Arguments.of(splitter, "1112111", List.of("", "12", "1")),
                    Arguments.of(StringSplitter.from("//,1\n"), "2,1,3", List.of("2", "", "3"))
            );
        }

    }
}
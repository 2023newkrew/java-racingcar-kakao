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
        void should_returnDefaultIsResult_when_givenCustomSeparator(String customSeparator, boolean result) {
            StringSplitter splitter = StringSplitter.from(customSeparator);
            assertThat(splitter == StringSplitter.getDefaultSplitter()).isEqualTo(result);
        }

        Stream<Arguments> should_returnDefaultIsResult_when_givenCustomSeparator() {
            return Stream.of(
                    Arguments.of(null, true),
                    Arguments.of("", true),
                    Arguments.of(" ", false)
            );
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
            StringSplitter blank1Splitter = StringSplitter.from(" ");
            StringSplitter blank2Splitter = StringSplitter.from("  ");
            StringSplitter splitter = StringSplitter.from("11");
            return Stream.of(
                    Arguments.of(nullSplitter, null, List.of("")),
                    Arguments.of(nullSplitter, "", List.of("")),
                    Arguments.of(nullSplitter, "1,2,3", List.of("1", "2", "3")),
                    Arguments.of(nullSplitter, "1, 2, 3", List.of("1", " 2", " 3")),
                    Arguments.of(blank1Splitter, "1, 2, 3", List.of("1", "", "2", "", "3")),
                    Arguments.of(blank2Splitter, "1,  2, 3", List.of("1", "", "2", " 3")),
                    Arguments.of(splitter, "1112111", List.of("", "12", "1")),
                    Arguments.of(StringSplitter.from(",1"), "2,1,3", List.of("2", "", "3"))
            );
        }

    }
}
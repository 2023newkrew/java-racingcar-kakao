package stringaccumulator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StringAccumulatorTest {

    @Mock
    StringSplitter stringSplitter;


    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class accumulate {
        @ParameterizedTest
        @MethodSource
        void should_returnSumOfTokens_when_validTokens(List<String> tokens, long expected) {
            String content = String.join(",", tokens);
            when(stringSplitter.split(content)).thenReturn(tokens);
            StringAccumulator stringAccumulator = StringAccumulator.from(stringSplitter);
            long result = stringAccumulator.accumulate(content);
            assertThat(result).isEqualTo(expected);
        }

        Stream<Arguments> should_returnSumOfTokens_when_validTokens() {
            return Stream.of(
                    Arguments.of(List.of(""), 0),
                    Arguments.of(List.of("1", "2", "3"), 6),
                    Arguments.of(List.of("1", " 2", " 3"), 6),
                    Arguments.of(List.of("1", "2 ", "3 "), 6),
                    Arguments.of(List.of("1", "", "2", "3"), 6),
                    Arguments.of(List.of(String.valueOf(Long.MAX_VALUE), "123"), Long.MAX_VALUE + 123)
            );
        }

        @ParameterizedTest
        @MethodSource
        void should_throwException_when_invalidTokens(List<String> tokens, String message) {
            String content = String.join(",", tokens);
            when(stringSplitter.split(content)).thenReturn(tokens);
            StringAccumulator stringAccumulator = StringAccumulator.from(stringSplitter);
            assertThatThrownBy(() -> stringAccumulator.accumulate(content))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage(message);
        }

        Stream<Arguments> should_throwException_when_invalidTokens() {
            return Stream.of(
                    Arguments.of(List.of("-1", "1"), "Illegal leading minus sign on unsigned string -1."),
                    Arguments.of(List.of("1 2", "3"), "For input string: \"1 2\""),
                    Arguments.of(List.of("asd"), "For input string: \"asd\""),
                    Arguments.of(List.of(Long.MAX_VALUE + "123"), "Error at index 19 in: \"922337203685477580712\"")
            );
        }
    }
}
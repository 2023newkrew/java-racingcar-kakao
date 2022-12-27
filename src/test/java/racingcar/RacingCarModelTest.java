package racingcar;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarModelTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ParseNames {
        @ParameterizedTest
        @MethodSource
        void should_parseNames_when_validNameLine(String nameLine, String[] names) {
            List<String> result = RacingCarModel.parseNames(nameLine);
            assertThat(result).containsExactly(names);
        }

        Stream<Arguments> should_parseNames_when_validNameLine() {
            return Stream.of(
                    Arguments.of(",abc", new String[]{"", "abc"}),
                    Arguments.of("abc, def, geh", new String[]{"abc", " def", " geh"})
            );
        }

        @Test
        void should_throwException_when_tooManyNames() {
            String nameLine = "abc,".repeat(100) + "abc";
            assertThatThrownBy(() -> RacingCarModel.parseNames(nameLine))
                    .isInstanceOf(RuntimeException.class);
        }
    }



}
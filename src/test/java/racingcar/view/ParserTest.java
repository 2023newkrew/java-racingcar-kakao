package racingcar.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class ParserTest {
    @CsvSource({"10,10", "100,100", "0,0", "9999,9999"})
    @ParameterizedTest
    void 문자열을_정수로_파싱한다(String input, int result) {
        assertThat(Parser.parseInt(input)).isEqualTo(result);
    }

    @ValueSource(strings = {"abcd", "가_나_다_라", "!:@"})
    @ParameterizedTest
    void 문자열을_정수로_파싱할_수_없을_경우_특정_정수를_반환한다(String input) {
        assertThat(Parser.parseInt(input)).isEqualTo(Parser.INTEGER_PARSER_ERROR);
    }
}
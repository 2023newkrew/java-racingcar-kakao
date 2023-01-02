package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.InputParser;

public class parserTest {

    @Test
    public void 입력값_파싱() {
        String[] carNames = InputParser.splitByComma("pobi,jaws,jayde");
        Assertions.assertThat(carNames).containsExactly("pobi", "jaws", "jayde");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "12:12", "500:500"}, delimiter = ':')
    public void 실행횟수_파싱(String input, int expected) {
        int answer = InputParser.parseStringToPositiveInt(input);
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "", "   "})
    public void 실행횟수_포맷_검증(String input) {
        Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            InputParser.parseStringToPositiveInt(input);
        }).withMessage("1 이상의 숫자만 입력해야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-12", "-2321312"})
    public void 실행횟수_양수_검증(String input) {
        Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            InputParser.parseStringToPositiveInt(input);
        }).withMessage("음수는 입력할 수 없습니다.");
    }
}

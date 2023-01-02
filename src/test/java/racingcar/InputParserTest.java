package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.InputParser;

public class InputParserTest {

    @Test
    @DisplayName("자동차 이름을 콤마로 분리한다.")
    public void testSplitInputByComma() {
        String[] carNames = InputParser.splitByComma("pobi,jaws,jayde");
        Assertions.assertThat(carNames).containsExactly("pobi", "jaws", "jayde");
    }

    @ParameterizedTest
    @DisplayName("실행 횟수를 양수로 변환한다.")
    @CsvSource(value = {"1:1", "12:12", "500:500"}, delimiter = ':')
    public void testCountToPositiveInt(String input, int expected) {
        int answer = InputParser.parseStringToPositiveInt(input);
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("실행 횟수는 숫자이어야 한다.")
    @ValueSource(strings = {"asd", "", "   "})
    public void testValidateCountIsNumber(String input) {
        Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            InputParser.parseStringToPositiveInt(input);
        }).withMessage("1 이상의 숫자만 입력해야합니다.");
    }

    @ParameterizedTest
    @DisplayName("실행 횟수는 양수이어야 한다.")
    @ValueSource(strings = {"0", "-12", "-2321312"})
    public void testValidateCountIsPositiveInt(String input) {
        Assertions.assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            InputParser.parseStringToPositiveInt(input);
        }).withMessage("음수는 입력할 수 없습니다.");
    }
}

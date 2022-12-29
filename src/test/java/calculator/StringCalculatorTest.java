package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    void 빈_문자열_입력시_0반환() {
        StringCalculator emptyStr = new StringCalculator("");
        assertThat(emptyStr.calculate()).isEqualTo(0);
    }

    @Test
    void 널_문자열_입력시_0반환() {
        StringCalculator nullStr = new StringCalculator(null);
        assertThat(nullStr.calculate()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3|6", "22,33,11:1:3|70", "3:1|4"}, delimiter = '|')
    void 기본적인_문자열_입력_테스트(String str, int expected) {
        StringCalculator basic = new StringCalculator(str);
        assertThat(basic.calculate()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123123|123123", "2413|2413", "99|99"}, delimiter = '|')
    void 숫자만_있는_문자열_입력_테스트(String str, int expected) {
        StringCalculator number = new StringCalculator(str);
        assertThat(number.calculate()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1[2,3:4", "39:2:1m3"})
    void 사용_불가능한_문자열_입력_테스트(String str) {
        StringCalculator invalid = new StringCalculator(str);
        assertThatThrownBy(invalid::calculate).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 사용_불가능한_커스텀_문자_입력() {
        StringCalculator invalid = new StringCalculator("//$\n1@2,3:4");
        assertThatThrownBy(invalid::calculate).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 커스텀_문자_정상_사용() {
        StringCalculator custom = new StringCalculator("//[!$#&\n1,2:3[4");
        assertThat(custom.calculate()).isEqualTo(10);
    }

    @Test
    void 음수_문자열_입력() {
        assertThatThrownBy(() -> new StringCalculator("-12,3:4")).isInstanceOf(RuntimeException.class);
    }
}

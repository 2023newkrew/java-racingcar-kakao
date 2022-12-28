package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    void emptyString() {
        StringCalculator emptyStr = new StringCalculator("");
        assertThat(emptyStr.calculate()).isEqualTo(0);
    }

    @Test
    void nullString() {
        StringCalculator nullStr = new StringCalculator(null);
        assertThat(nullStr.calculate()).isEqualTo(0);
    }

    @Test
    void basicString() {
        StringCalculator basic = new StringCalculator("1,2:3");
        assertThat(basic.calculate()).isEqualTo(6);
    }

    @Test
    void numberString() {
        StringCalculator number = new StringCalculator("123123");
        assertThat(number.calculate()).isEqualTo(123123);
    }

    @Test
    void invalidString() {
        StringCalculator invalid = new StringCalculator("1[2,3:4");
        assertThatThrownBy(invalid::calculate).isInstanceOf(RuntimeException.class);
    }

    @Test
    void invalidCustomString() {
        StringCalculator invalid = new StringCalculator("//$\n1@2,3:4");
        assertThatThrownBy(invalid::calculate).isInstanceOf(RuntimeException.class);
    }

    @Test
    void customString() {
        StringCalculator custom = new StringCalculator("//[!$#&\n1,2:3[4");
        assertThat(custom.calculate()).isEqualTo(10);
    }

    @Test
    void minusString() {
        assertThatThrownBy(() -> {
            new StringCalculator("-12,3:4");
        }).isInstanceOf(RuntimeException.class);
    }
}

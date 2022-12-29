package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("구분자를 추가하지 않은 경우 덧셈 수행")
    void addNumTest() {
        Calculator calculator = new Calculator("//+\n1,2:3+4");

        assertThat(calculator.run()).isEqualTo(10);
    }

    @Test
    @DisplayName("구분자를 추가한 경우 덧셈 수행")
    void delimiterAddNumTest() {
        Calculator calculator = new Calculator("//+\n1,2:3+4");

        assertThat(calculator.run()).isEqualTo(10);
    }
}

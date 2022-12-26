package string_addition_calculator;

// "" -> 0
// "1,2,3" -> 6
// "1,2:3" -> 6
// "//;\n1;2;3" -> 6
// "-1" -> IllegalArgumentException
// "hello" -> IllegalArgumentException

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @Test
    void calculate1() {
        int result = calculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void calculate2() {
        int result = calculator.calculate("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void calculate3() {
        int result = calculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void calculate4() {
        int result = calculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void calculate5() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            calculator.calculate("-1");
        }).withMessage("양식에 알맞게 입력해주세요.");
    }

    @Test
    void calculate6() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            calculator.calculate("hello");
        }).withMessage("양식에 알맞게 입력해주세요.");
    }
}

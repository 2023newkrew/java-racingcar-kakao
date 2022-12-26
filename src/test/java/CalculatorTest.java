import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void emptyOrNullString(String input){
        Integer result = calculator.calc(input);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void oneNumber() {
        String input = "1";
        Integer result = calculator.calc(input);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void sumOfComma() {
        String input = "1,2";
        Integer result = calculator.calc(input);
        Assertions.assertThat(result).isEqualTo(3);
    }
}

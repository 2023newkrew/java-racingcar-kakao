import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
public class CalculatorTest {
    @Test
    void checkEmptyText(){
        Calculator calculator = new Calculator("");

        assertThat(calculator.isEmptyOrNull()).isEqualTo(true);
        assertThat(calculator.run()).isEqualTo(0);
    }

    @Test
    void checkNullText(){
        Calculator calculator = new Calculator(null);

        assertThat(calculator.isEmptyOrNull()).isEqualTo(true);
        assertThat(calculator.run()).isEqualTo(0);
    }

    @Test
    void singleNoText(){
        Calculator calculator = new Calculator("1");

        assertThat(calculator.run()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {".", "-1", "-2", ";" ,"!"})
    void singleInvalidText(String text){
        Calculator calculator = new Calculator(text);

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(calculator::run);
    }
}

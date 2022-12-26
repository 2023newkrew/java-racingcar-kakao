import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

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

    @Test
    void checkSplitTextWithComma(){
        Calculator calculator = new Calculator("1,2");

        assertThat(calculator.splitText()).isEqualTo(Arrays.asList(1, 2));
    }
    @Test
    void checkSplitTextWithColon(){
        Calculator calculator = new Calculator("1:2:3");

        assertThat(calculator.splitText()).isEqualTo(Arrays.asList(1,2,3));
    }
    @Test
    void checkSplitTextWithCommaAndColon(){
        Calculator calculator = new Calculator("1,2:3");

        assertThat(calculator.splitText()).isEqualTo(Arrays.asList(1,2,3));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,-2:3", "1, 2:3", "1,,2"})
    void checkSplitInvalidTextWithDelimiter(String text){
        Calculator calculator = new Calculator(text);

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(calculator::splitText);
    }

    @Test
    void getIfCustomDelimiterExist(){
        Calculator calculator = new Calculator("//;\n1;2;3");

        assertThat(calculator.getCustomDelimiter()).isEqualTo(";");
    }

    @Test
    void getNullIfCustomDelimiterNotExist(){
        Calculator calculator = new Calculator("1;2;3");

        assertThat(calculator.getCustomDelimiter()).isNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {";", "!", "$"})
    void buildDelimiters(String customDelimiter){
        assertThat(Calculator.buildDelimiters(customDelimiter)).isEqualTo("[,:" + customDelimiter + "]");
    }
}

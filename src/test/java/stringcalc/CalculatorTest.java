package stringcalc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void calculate(){
        //given
        String input = "1,2,3";

        //when
        Calculator calculator = new Calculator();
        Long sum = calculator.calculate(input);

        //then
        assertThat(sum).isEqualTo(6L);
    }

    @Test
    public void calculate_empty(){
        //given
        String input = "";

        //when
        Calculator calculator = new Calculator();
        Long sum = calculator.calculate(input);

        //then
        assertThat(sum).isZero();
    }
}

package stringcalc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void calculate(){
        //given
        String input = "1,2,3";

        //when
        StringCalculator stringCalculator = new StringCalculator();
        Long sum = stringCalculator.calculate(input);

        //then
        assertThat(sum).isEqualTo(6L);
    }

    @Test
    public void calculate_empty(){
        //given
        String input = "";

        //when
        StringCalculator stringCalculator = new StringCalculator();
        Long sum = stringCalculator.calculate(input);

        //then
        assertThat(sum).isZero();
    }

    @Test
    public void calculate_customSeparator() {
        //given
        String input = "//;\n1;2;3";

        //when
        StringCalculator stringCalculator = new StringCalculator();
        Long sum = stringCalculator.calculate(input);

        //then
        assertThat(sum).isEqualTo(6L);
    }
}

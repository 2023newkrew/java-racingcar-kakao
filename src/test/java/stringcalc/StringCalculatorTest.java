package stringcalc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    void calculate(){
        //given
        String input = "1,2,3";

        //when
        StringCalculator stringCalculator = new StringCalculator();
        Long sum = stringCalculator.calculate(input);

        //then
        assertThat(sum).isEqualTo(6L);
    }

    @Test
    void calculate_empty(){
        //given
        String input = "";

        //when
        StringCalculator stringCalculator = new StringCalculator();
        Long sum = stringCalculator.calculate(input);

        //then
        assertThat(sum).isZero();
    }

    @Test
    void calculate_customSeparator() {
        //given
        String input = "//;\n1;2;3";

        //when
        StringCalculator stringCalculator = new StringCalculator();
        Long sum = stringCalculator.calculate(input);

        //then
        assertThat(sum).isEqualTo(6L);
    }
}

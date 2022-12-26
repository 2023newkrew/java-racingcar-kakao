package stringcalc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void calculate(){
        //given
        List<Long> numbers = Arrays.asList(1L, 2L, 3L);

        //when
        Calculator calculator = new Calculator();
        Long sum = calculator.sum(numbers);

        //then
        assertThat(sum).isEqualTo(6L);
    }

    @Test
    public void calculate_empty(){
        //given
        List<Long> numbers = new ArrayList<>();

        //when
        Calculator calculator = new Calculator();
        Long sum = calculator.sum(numbers);

        //then
        assertThat(sum).isZero();
    }
}

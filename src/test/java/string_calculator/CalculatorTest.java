package string_calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import string_calculator.Calculator;

public class CalculatorTest {

    @Test
    void addTest() {
        Integer[] inputs0 = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Assertions.assertThat(Calculator.add(inputs0)).isEqualTo(55);

        Integer[] inputs1 = new Integer[]{};

        Assertions.assertThat(Calculator.add(inputs1)).isEqualTo(0);
    }
}

package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("계산기 더하기 연산 검증")
    @Test
    void addTest() {
        //given
        Integer[] inputs0 = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] inputs1 = new Integer[]{};
        //when
        //then
        Assertions.assertThat(Calculator.add(inputs0)).isEqualTo(55);
        Assertions.assertThat(Calculator.add(inputs1)).isEqualTo(0);
    }
}

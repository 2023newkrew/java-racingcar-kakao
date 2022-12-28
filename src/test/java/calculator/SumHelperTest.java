package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SumHelperTest {
    @Test
    void isValidNumber_false() {
        SumHelper sumHelper = new SumHelper();
        assertFalse(sumHelper.isValidNumber("a"));
        assertFalse(sumHelper.isValidNumber("-2"));
        assertFalse(sumHelper.isValidNumber("1,"));
    }

    @Test
    void isValidNumber_true() {
        SumHelper sumHelper = new SumHelper();
        assertTrue(sumHelper.isValidNumber("1"));
        assertTrue(sumHelper.isValidNumber("23"));
    }

    @Test
    void sum() {
        String[] array1 = {"1","2","3"};
        String[] array2 = {"1","2","4"};

        SumHelper sumHelper1 = SumHelper.sumHelperForTest(array1);
        SumHelper sumHelper2 = SumHelper.sumHelperForTest(array2);

        int result1 = sumHelper1.sum();
        int result2 = sumHelper2.sum();

        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(7);
    }

    @Test
    void sum_wrong_input() {
        String[] array = {"a","2","3"};

        SumHelper sumHelper = SumHelper.sumHelperForTest(array);

        assertThatThrownBy(sumHelper::sum)
                .isExactlyInstanceOf(RuntimeException.class);
    }
}

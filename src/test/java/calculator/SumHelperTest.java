package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SumHelperTest {
    SumHelper sumHelper;
    @BeforeEach
    void setup() {
        sumHelper = new SumHelper();
    }

    @Test
    void 유효한_숫자가_아닐_경우_false_를_반환한다() {
        assertFalse(sumHelper.isValidNumber("a"));
        assertFalse(sumHelper.isValidNumber("-2"));
        assertFalse(sumHelper.isValidNumber("1,"));
    }

    @Test
    void 유효한_숫자가_맞을_경우_true_를_반환한다() {
        assertTrue(sumHelper.isValidNumber("1"));
        assertTrue(sumHelper.isValidNumber("23"));
    }

    @Test
    void 주어진_숫자들의_합을_반환한다() {
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
    void 숫자로_변환할_수_없는_경우_예외가_발생한다() {
        String[] array = {"a","2","3"};
        SumHelper sumHelper = SumHelper.sumHelperForTest(array);

        assertThatThrownBy(sumHelper::sum)
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}

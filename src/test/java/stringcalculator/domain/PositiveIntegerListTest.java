package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.domain.PositiveIntegerList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveIntegerListTest {

    @Test
    @DisplayName("커스텀 구분자로 구분된 양의 정수들을 더한다.")
    void addNumber() {
        String[] values = { "1", "2", "3" };
        PositiveIntegerList numberList = new PositiveIntegerList(values);

        int result = numberList.calculateSum();
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("0보다 작은 값이 들어올 경우 객체가 생성되지 않는다.")
    void throwExceptionIfNegative() {
        String[] values = { "1", "-8", "6" };

        assertThatThrownBy(() -> new PositiveIntegerList(values))
                .isInstanceOf(RuntimeException.class);
    }


}
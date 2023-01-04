package stringcalculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.domain.Splitter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SplitterTest {

    private Splitter splitter;

    @BeforeEach
    void setUp() {
        splitter = new Splitter(List.of(",", ":"));
    }

    @DisplayName("구분자가 숫자이거나, 문자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "6", ";_", "1", ")(*" })
    void validateDelimiter(String delimiter) {
        assertThatThrownBy(() -> splitter.addDelimiter(delimiter))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("기본 구분자인 쉼표(,) 또는 콜론(:)을 기준으로 분리한다.")
    void splitStringByBaseDelimiters() {
        String input = "1:2,3";

        String[] result = splitter.splitByDelimiters(input);

        assertThat(result.length).isEqualTo(3);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("정상적인 커스텀 구분자가 등록되면 이후 해당 구분자를 기준으로 분리가 가능해진다.")
    void splitStringByCustomDelimiter() {
        String customDelimiter = "_", input = "6_1:5";

        splitter.addDelimiter(customDelimiter);
        String[] result = splitter.splitByDelimiters(input);

        assertThat(result.length).isEqualTo(3);
        assertThat(result).containsExactly("6", "1", "5");
    }

}

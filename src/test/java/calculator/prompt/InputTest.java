package calculator.prompt;

import calculator.domain.calculator.prompt.Input;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {

    @ParameterizedTest
    @DisplayName("빈 문자열이거나 null값이 인풋일 경우 true를 리턴한다.")
    @NullAndEmptySource
    public void empty(String property) {
        Input input = new Input(property);
        Assertions.assertThat(input.isEmpty())
                .isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("빈 문자열이거나 null값이 인풋이 아닐 경우 false를 리턴한다.")
    @ValueSource(strings = "java,python,clang,rust,go,kotlin")
    public void notEmpty(String property) {
        Input input = new Input(property);
        Assertions.assertThat(input.isEmpty())
                .isEqualTo(false);
    }

}

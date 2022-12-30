package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BasicValidatorTest {

    BasicValidator validator;

    @BeforeEach
    void setup() {
        validator = new BasicValidator();
    }

    @Test
    @DisplayName("정수로 변환 가능한 문자열은 true를 반환한다")
    void isInteger_true() {
        String one = "1";
        String oneWithBlank = " 1 ";
        String minusOne = "-1";
        String bryan = "bryan";

        assertThat(validator.isInteger(one)).isEqualTo(true);
        assertThat(validator.isInteger(oneWithBlank)).isEqualTo(false);
        assertThat(validator.isInteger(minusOne)).isEqualTo(true);
        assertThat(validator.isInteger(bryan)).isEqualTo(false);

    }

    @Test
    @DisplayName("0, 또는 양의 정수만이 시도 횟수 입력값으로 적합하다")
    void isValidRoundInput() {
        String one = "1";
        String oneWithBlank = " 1 ";
        String minusOne = "-1";
        String bryan = "bryan";

        assertThat(validator.isValidRoundInput(one)).isEqualTo(true);
        assertThat(validator.isInteger(oneWithBlank)).isEqualTo(false);
        assertThat(validator.isValidRoundInput(minusOne)).isEqualTo(false);
        assertThat(validator.isValidRoundInput(bryan)).isEqualTo(false);
    }

    @Test
    @DisplayName("문자열의 길이는 정해진 한계를 넘지 않는다")
    void isLengthLessThanLimit() {
        String name1 = "name";
        String name2 = "more than 5 letters";

        assertThat(validator.isLengthLessThanLimit(name1)).isEqualTo(true);
        assertThat(validator.isLengthLessThanLimit(name2)).isEqualTo(false);
    }

    @Test
    @DisplayName("이름은 쉼표로 구분하며, 각 이름은 정해진 길이를 넘지 않는다")
    void isValidNamesInput() {
        String namesInput = "a, b, c";
        String namesInput2 = "longName, a, b";
        String blankInput = " ";

        assertThat(validator.isValidNamesInput(namesInput)).isEqualTo(true);
        assertThat(validator.isValidNamesInput(namesInput2)).isEqualTo(false);
        assertThat(validator.isValidNamesInput(blankInput)).isEqualTo(false);
    }
}
package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputTest {
    Input input = new Input();
    @ParameterizedTest
    @ValueSource(strings={"daniel",""})
    void inputLengthException(String inputStr) {
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> input.validateLength(inputStr));
    }
    @Test
    void inputLengthNotException() {
        String inputStr = "dan";
        assertThatCode(()-> input.validateLength(inputStr)).doesNotThrowAnyException();
    }

    @Test
    void arrayLengthException() {
        String[] inputStr = {"kim"};
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> input.validateArrayLength(inputStr)).withMessage("경주에 참여할 자동차는 2대 이상이어야 합니다.");

    }
    @Test
    void arrayLengthNotException() {
        String[] inputStr = {"kim", "lee"};
        assertThatCode(()-> input.validateArrayLength(inputStr)).doesNotThrowAnyException();
    }

    @Test
    void EachStringNotException(){
        String[] inputStr = {"kim", "lee", "han"};
        assertThatCode(()-> input.validateEachString(inputStr)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings={"daniel", ""})
    void EachStringException(String abnormal){
        String[] inputStr = {"kim", "lee", abnormal};
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> input.validateEachString(inputStr)).withMessage("자동차 이름의 길이는 5글자 이하여야 합니다.");
    }

    @Test
    void duplicatedCarNameNotExceptionTest() {
        String[] inputStr = {"kim", "lee", "park"};
        assertThatCode(()-> input.validateDuplication(inputStr)).doesNotThrowAnyException();
    }

    @Test
    void duplicatedCarNameExceptionTest() {
        String[] inputStr = {"kim", "lee", "kim"};
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(()-> input.validateDuplication(inputStr)).withMessage("경주에 참여하는 자동차의 이름에 중복이 있습니다.");
    }

    @Test
    void trialCountNotExceptionTest() {
        String trialCount = "3";
        Assertions.assertThat(input.validateTrialCount(trialCount)).isEqualTo(3);

    }

    @ParameterizedTest
    @ValueSource(strings = {"3d", "xx", "-1", "0"})
    void trialCountExceptionTest(String trialCount) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()-> input.validateTrialCount(trialCount));
    }

}

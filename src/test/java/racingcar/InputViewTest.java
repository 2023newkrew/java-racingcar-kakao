package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;
import racingcar.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputViewTest {

    @DisplayName("자동차 이름의 길이는 0이상 5이하 여야 함 (예외발생)")
    @ParameterizedTest
    @ValueSource(strings={"daniel",""})
    void inputLengthException(String inputStr) {
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    InputView.validateLength(inputStr);
                });
    }

    @DisplayName("자동차 이름의 길이는 0이상 5이하 여야 함 (통과)")
    @Test
    void inputLengthNotException() {
        String inputStr = "dan";
        assertThatCode(()->{
            InputView.validateLength(inputStr);
        }).doesNotThrowAnyException();
    }

    @DisplayName("자동차의 대수는 2대 이상이어야 함 (예외발생)")
    @Test
    void arrayLengthException() {
        String[] inputStr = {"kim"};
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    InputView.validateArrayLength(inputStr);
                });
    }

    @DisplayName("자동차의 대수는 2대 이상이어야 함 (통과)")
    @Test
    void arrayLengthNotException() {
        String[] inputStr = {"kim", "lee"};
        assertThatCode(()->{
            InputView.validateArrayLength(inputStr);
        }).doesNotThrowAnyException();
    }

    @DisplayName("여러대의 자동차 이름의 길이는 모두 1 이상 5 이하여야 함 (통과)")
    @Test
    void EachStringNotException(){
        String[] inputStr = {"kim", "lee", "han"};
        assertThatCode(()->{
            InputView.validateEachString(inputStr);
        }).doesNotThrowAnyException();
    }

    @DisplayName("여러대의 자동차 이름의 길이는 모두 1 이상 5 이하여야 함 (예외발생)")
    @ParameterizedTest
    @ValueSource(strings={"daniel", ""})
    void EachStringException(String abnormal){
        String[] inputStr = {"kim", "lee", abnormal};
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    InputView.validateEachString(inputStr);
                });
    }

    @DisplayName("자동차 이름은 중복되지 않아야 함 (통과)")
    @Test
    void duplicatedCarNameNotExceptionTest() {
        String[] inputStr = {"kim", "lee", "park"};
        assertThatCode(()->{
            InputView.validateDuplication(inputStr);
        }).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름은 중복되지 않아야 함 (예외발생)")
    @Test
    void duplicatedCarNameExceptionTest() {
        String[] inputStr = {"kim", "lee", "kim"};
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(()->{
                    InputView.validateDuplication(inputStr);
                });
    }

    @DisplayName("시도 회수는 정수여야 하며 1 이상이어야 함 (통과)")
    @Test
    void trialCountNotExceptionTest() {
        String trialCount = "3";
        Assertions.assertThatCode(()->{
            InputView.validateTrialCount(trialCount);
        }).doesNotThrowAnyException();
    }

    @DisplayName("시도 회수는 정수여야 하며 1 이상이어야 함 (예외발생)")
    @ParameterizedTest
    @ValueSource(strings = {"3d", "xx", "-1", "0"})
    void trialCountExceptionTest(String trialCount) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->{
                    InputView.validateTrialCount(trialCount);
                });
    }
}

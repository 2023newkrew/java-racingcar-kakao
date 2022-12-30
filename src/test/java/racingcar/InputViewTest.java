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

    @DisplayName("자동차 이름의 길이가 1~5사이 범위가 아닌 경우 예외가 발생해야함")
    @ParameterizedTest
    @ValueSource(strings = {"daniel", ""})
    void 자동차_이름의_길이_적합성_예외발생(String inputStr) {
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    InputView.validateCarNameLength(inputStr);
                });
    }

    @DisplayName("자동차 이름의 길이가 1~5사이 범위에 있는 경우 예외가 발생하지 않아야함")
    @Test
    void 자동차_이름의_길이_적합성_통과() {
        String inputStr = "dan";
        assertThatCode(() -> {
            InputView.validateCarNameLength(inputStr);
        }).doesNotThrowAnyException();
    }

    @DisplayName("자동차의 대수가 1대 이하인 경우 예외가 발생해야함")
    @Test
    void 자동차_대수_적합성_예외발생() {
        String[] inputStr = {"kim"};
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    InputView.validateCountOfCars(inputStr);
                });
    }

    @DisplayName("자동차의 대수가 2대 이상인 경우 예외가 발생하지 않아야함")
    @Test
    void 자동차_대수_적합성_통과() {
        String[] inputStr = {"kim", "lee"};
        assertThatCode(() -> {
            InputView.validateCountOfCars(inputStr);
        }).doesNotThrowAnyException();
    }


    @DisplayName("자동차의 이름이 중복되지 않은 경우 예외가 발생하지 않아야함")
    @Test
    void 여러대의_자동차_이름의_중복_통과() {
        String[] inputStr = {"kim", "lee", "park"};
        assertThatCode(() -> {
            InputView.validateDuplicationOfCarNames(inputStr);
        }).doesNotThrowAnyException();
    }

    @DisplayName("자동차의 이름이 중복된 경우 예외가 발생해야함")
    @Test
    void 여러대의_자동차_이름의_중복_예외발생() {
        String[] inputStr = {"kim", "lee", "kim"};
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    InputView.validateDuplicationOfCarNames(inputStr);
                });
    }

    @DisplayName("시도 횟수가 정수이며 1 이상인 경우 예외가 발생하지 않아야함")
    @Test
    void 시도_횟수_적합성_통과() {
        String trialCount = "3";
        Assertions.assertThatCode(() -> {
            InputView.validateTrialCount(trialCount);
        }).doesNotThrowAnyException();
    }

    @DisplayName("시도 횟수가 정수가 아니거나 0 이하인 경우 예외가 발생해야함")
    @ParameterizedTest
    @ValueSource(strings = {"3d", "xx", "-1", "0"})
    void 시도_횟수_적합성_예외발생(String trialCount) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    InputView.validateTrialCount(trialCount);
                });
    }
}

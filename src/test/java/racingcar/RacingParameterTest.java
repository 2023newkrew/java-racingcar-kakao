package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingController;
import racingcar.exception.RacingException;
import racingcar.exception.RacingExceptionCode;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingParameterTest {

    RacingController rc = new RacingController();

    @ParameterizedTest
    @ValueSource(strings = {"a,,b", "a,daniel,b"})
    @DisplayName("경주에 참가하는 자동차의 길이가 5를 초과할때 길이 관련 예외를 발생시킨다.")
    void carNameLengthExceptionTest(String inputStr) {
        assertThatExceptionOfType(RacingException.class)
                .isThrownBy(() -> {
                    rc.processCarNames(inputStr);
                }).withMessage(RacingExceptionCode.INVALID_CAR_LENGTH.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "a,bc,def,ghij"})
    @DisplayName("입력값이 요구사항대로 주어질 때 예외를 발생시키지 않는다.")
    void carNameLengthNoExceptionTest(String inputStr) {
        Assertions.assertThatCode(() -> rc.processCarNames(inputStr)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "bc", "def", "ghij"})
    @DisplayName("입력값의 자동차가 1개일 때 경주 참여 자동차 수 관련 예외를 발생시킨다.")
    void RacingCarNumberException(String inputStr) {
        assertThatExceptionOfType(RacingException.class)
                .isThrownBy(
                        () -> rc.processCarNames(inputStr)
                ).withMessage(RacingExceptionCode.INVALID_CARS_SIZE.getErrorMessage());
    }

    @Test
    @DisplayName("입력값의 자동차 이름에 중복이 있을 때 중복 관련 예외를 발생시킨다.")
    void duplicatedCarNameExceptionTest() {
        String inputStr = "kim,lee,kim";
        assertThatExceptionOfType(RacingException.class)
                .isThrownBy(() -> rc.processCarNames(inputStr)).withMessage(RacingExceptionCode.CAR_NAME_DUPLICATION.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"3d", "", "-1", "0"})
    @DisplayName("라운드 횟수 입력시 자연수가 아닌 입력에 대해 예외를 발생시킨다.")
    void trialCountExceptionTest(String trialCount) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> rc.processTrialNumber(trialCount));
    }

}

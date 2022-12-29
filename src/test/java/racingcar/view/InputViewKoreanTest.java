package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.InvalidInputException;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputViewKoreanTest {
    InputViewKorean inputViewKorean;

    @BeforeEach
    void initialization(){
        inputViewKorean = new InputViewKorean(System.in);
    }
    @ParameterizedTest
    @ValueSource(strings={"daniel",""})
    void inputLengthException(String inputStr) {
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    inputViewKorean.scanNames(inputStr+",han");
                }).withMessage("자동차의 길이는 1~5 사이어야 합니다.");
    }
    @Test
    void inputLengthNotException() {
        String inputStr = "dan";
        assertThatCode(()->{
            inputViewKorean.scanNames(inputStr+",han");
        }).doesNotThrowAnyException();
    }

    @Test
    void arrayLengthException() {
        String inputStr = "kim";
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    inputViewKorean.scanNames(inputStr);
                }).withMessage("두 개 이상의 자동차를 입력해 주세요");

    }
    @Test
    void arrayLengthNotException() {
        String inputStr = "kim,lee";
        assertThatCode(()->{
            inputViewKorean.scanNames(inputStr);
        }).doesNotThrowAnyException();
    }

    @Test
    void EachStringNotException(){
        String inputStr = "kim,lee,han";
        assertThatCode(()->{
            inputViewKorean.scanNames(inputStr);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings={"daniel", ""})
    void EachStringException(String abnormal){
        String inputStr = "kim,lee,abnormal";
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    inputViewKorean.scanNames(inputStr);
                }).withMessage("자동차의 길이는 1~5 사이어야 합니다.");
    }

    @Test
    void duplicatedCarNameExceptionTest() {
        String inputStr = "kim,lee,kim";
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(()->{
                    inputViewKorean.scanNames(inputStr);
                }).withMessage("중복된 이름의 자동차를 입력하지 마세요.");
    }

    @Test
    void trialCountNotExceptionTest() {
        String trialCount = "3";
        Assertions.assertThat(inputViewKorean.scanTrialCount(trialCount)).isEqualTo(3);

    }

    @ParameterizedTest
    @ValueSource(strings = {"3d", "xx"})
    void trialCountNotNumber(String trialCount) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(()->{
                    inputViewKorean.scanTrialCount(trialCount);
                });
    }
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void trialCountNotPositive(String trialCount) {
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(()->{
                    inputViewKorean.scanTrialCount(trialCount);
                }).withMessage("시도 회수는 1 이상이여야 합니다.");
    }

}

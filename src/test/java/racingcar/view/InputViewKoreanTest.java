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
        inputViewKorean = new InputViewKorean(System.in, System.out);
    }
    @ParameterizedTest
    @ValueSource(strings={"daniel",""})
    void inputLengthException(String inputStr) {
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    inputViewKorean.getNamesArray(inputStr+",han");
                }).withMessageStartingWith("1");
    }
    @Test
    void inputLengthNotException() {
        String inputStr = "dan";
        assertThatCode(()->{
            inputViewKorean.getNamesArray(inputStr+",han");
        }).doesNotThrowAnyException();
    }

    @Test
    void arrayLengthException() {
        String inputStr = "kim";
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    inputViewKorean.getNamesArray(inputStr);
                }).withMessageStartingWith("2");

    }
    @Test
    void arrayLengthNotException() {
        String inputStr = "kim,lee";
        assertThatCode(()->{
            inputViewKorean.getNamesArray(inputStr);
        }).doesNotThrowAnyException();
    }

    @Test
    void EachStringNotException(){
        String inputStr = "kim,lee,han";
        assertThatCode(()->{
            inputViewKorean.getNamesArray(inputStr);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings={"daniel", ""})
    void EachStringException(String abnormal){
        String inputStr = "kim,lee,abnormal";
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    inputViewKorean.getNamesArray(inputStr);
                }).withMessageStartingWith("1");
    }

    @Test
    void duplicatedCarNameExceptionTest() {
        String inputStr = "kim,lee,kim";
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(()->{
                    inputViewKorean.getNamesArray(inputStr);
                }).withMessageStartingWith("3");
    }

    @Test
    void trialCountNotExceptionTest() {
        String trialCount = "3";
        Assertions.assertThat(inputViewKorean.getTrialCount(trialCount)).isEqualTo(3);

    }

    @ParameterizedTest
    @ValueSource(strings = {"3d", "xx"})
    void trialCountNotNumber(String trialCount) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(()->{
                    inputViewKorean.getTrialCount(trialCount);
                });
    }
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void trialCountNotPositive(String trialCount) {
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(()->{
                    inputViewKorean.getTrialCount(trialCount);
                }).withMessageStartingWith("4");
    }

}

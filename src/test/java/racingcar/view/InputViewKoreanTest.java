package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.InvalidInputException;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputViewKoreanTest {
    PrintStream printStream = new PrintStream(new OutputStream() { // 출력을 무시하는 용도로 쓰임
        @Override
        public void write(int b) throws IOException {}
    });

    @ParameterizedTest
    @ValueSource(strings={"daniel",""})
    void inputLengthException(String inputStr) {
        InputStream in = new ByteArrayInputStream((inputStr+",han").getBytes());
        InputViewKorean inputViewKorean = new InputViewKorean(in, printStream);

        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    inputViewKorean.getNamesArray();
                }).withMessageStartingWith("1");
    }
    @Test
    void inputLengthNotException() {
        String inputStr = "dan";
        InputStream in = new ByteArrayInputStream((inputStr+",han").getBytes());
        InputViewKorean inputViewKorean = new InputViewKorean(in, printStream);
        assertThatCode(()->{
            inputViewKorean.getNamesArray();
        }).doesNotThrowAnyException();
    }

    @Test
    void arrayLengthException() {
        String inputStr = "dan";
        InputStream in = new ByteArrayInputStream((inputStr).getBytes());
        InputViewKorean inputViewKorean = new InputViewKorean(in, printStream);
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    inputViewKorean.getNamesArray();
                }).withMessageStartingWith("2");

    }
    @Test
    void arrayLengthNotException() {
        String inputStr = "kim,lee";
        InputStream in = new ByteArrayInputStream((inputStr).getBytes());
        InputViewKorean inputViewKorean = new InputViewKorean(in, printStream);
        assertThatCode(()->{
            inputViewKorean.getNamesArray();
        }).doesNotThrowAnyException();
    }

    @Test
    void EachStringNotException(){
        String inputStr = "kim,lee,han";
        InputStream in = new ByteArrayInputStream((inputStr).getBytes());
        InputViewKorean inputViewKorean = new InputViewKorean(in, printStream);
        assertThatCode(()->{
            inputViewKorean.getNamesArray();
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings={"daniel", ""})
    void EachStringException(String abnormal){
        String inputStr = abnormal+",kim,lee";
        InputStream in = new ByteArrayInputStream((inputStr).getBytes());
        InputViewKorean inputViewKorean = new InputViewKorean(in, printStream);
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    inputViewKorean.getNamesArray();
                }).withMessageStartingWith("1");
    }

    @Test
    void duplicatedCarNameExceptionTest() {
        String inputStr = "kim,lee,kim";
        InputStream in = new ByteArrayInputStream((inputStr).getBytes());
        InputViewKorean inputViewKorean = new InputViewKorean(in, printStream);
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(()->{
                    inputViewKorean.getNamesArray();
                }).withMessageStartingWith("3");
    }

    @Test
    void trialCountNotExceptionTest() {
        String inputStr = "3";
        InputStream in = new ByteArrayInputStream((inputStr).getBytes());
        InputViewKorean inputViewKorean = new InputViewKorean(in, printStream);
        Assertions.assertThat(inputViewKorean.getTrialCount()).isEqualTo(3);

    }

    @ParameterizedTest
    @ValueSource(strings = {"3d", "xx"})
    void trialCountNotNumber(String inputStr) {
        InputStream in = new ByteArrayInputStream((inputStr).getBytes());
        InputViewKorean inputViewKorean = new InputViewKorean(in, printStream);
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(()->{
                    inputViewKorean.getTrialCount();
                });
    }
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void trialCountNotPositive(String inputStr) {
        InputStream in = new ByteArrayInputStream((inputStr).getBytes());
        InputViewKorean inputViewKorean = new InputViewKorean(in, printStream);
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(()->{
                    inputViewKorean.getTrialCount();
                }).withMessageStartingWith("4");
    }

}

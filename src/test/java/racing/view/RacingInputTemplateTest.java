package racing.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.ErrorCode;
import racing.exception.RacingException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class RacingInputTemplateTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "99", "  8"})
    public void 시도횟수로_0이상인_수의_문자열이_입력되면_값_반환(String attempt){
        InputStream inputStream = new ByteArrayInputStream(attempt.getBytes());
        System.setIn(inputStream);
        RacingInputTemplate racingInputTemplate = new RacingInputTemplate(new Scanner(System.in));

        assertThat(racingInputTemplate.inputAttempt()).isEqualTo(Integer.parseInt(attempt.trim()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-99"})
    public void 시도횟수로_음수문자열이_입력되면_예외를_반환(String attempt){
        InputStream inputStream = new ByteArrayInputStream(attempt.getBytes());
        System.setIn(inputStream);
        RacingInputTemplate racingInputTemplate = new RacingInputTemplate(new Scanner(System.in));

        assertThatThrownBy(racingInputTemplate::inputAttempt)
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.NEGATIVE_ATTEMPT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "-1a"})
    public void 시도횟수로_숫자형식이_아닌_문자열이_입력되면_예외를_반환(String attempt){
        InputStream inputStream = new ByteArrayInputStream(attempt.getBytes());
        System.setIn(inputStream);
        RacingInputTemplate racingInputTemplate = new RacingInputTemplate(new Scanner(System.in));

        assertThatThrownBy(racingInputTemplate::inputAttempt)
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.NOT_IN_NUMBER_FORMAT.getMessage());
    }
}

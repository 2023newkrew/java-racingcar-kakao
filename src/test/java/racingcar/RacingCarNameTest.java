package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.RacingCarName;
import racingcar.view.InputView;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarNameTest {

    @ParameterizedTest(name = "name : {0}")
    @DisplayName("이름 유효성 검사 통과 테스트")
    @ValueSource(strings = {"aiden", "jack,oscar,jerry", "tom,matt,right"})
    public void validateNamePass(final String name) {
        assertDoesNotThrow(() -> RacingCarName.parseCarNames(name));
    }

    @ParameterizedTest(name = "name : {0}")
    @DisplayName("이름 글자 수 예외 테스트")
    @ValueSource(strings = {"jack,,,gene", "jack,oscar.award,tom", "tom,matt,wronglongname"})
    public void validateNameException(final String name) {
        assertThrows(IllegalArgumentException.class, () -> RacingCarName.parseCarNames(name));
    }

    @Test
    @DisplayName("자동차 이름들을 쉼표 기준으로 분리하여 반환하는 기능 테스트")
    public void inputCarsName() {
        //when
        List<String> carNames = RacingCarName.parseCarNames("oscar,gene,aiden");

        //then
        assertEquals("oscar",carNames.get(0));
        assertEquals("gene",carNames.get(1));
        assertEquals("aiden",carNames.get(2));
    }
}

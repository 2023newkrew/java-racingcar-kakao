package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class IOViewTest {

    @Test
    @DisplayName("자동차들의 이름을 입력받고 리스트를 반환하는 기능")
    public void inputCarsName() {
        //given
        IO ioView = new IO();

        //when
        List<String> carNames = ioView.parseCarNames("oscar,gene,longwrongname");

        //then
        assertEquals("oscar",carNames.get(0));
        assertEquals("gene ",carNames.get(1));
        assertEquals("longw",carNames.get(2));
    }

}

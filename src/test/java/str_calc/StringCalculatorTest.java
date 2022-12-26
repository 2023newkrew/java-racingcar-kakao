package str_calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 분리 기능 테스트")
    public void splitText() {
        //given
        StringCalculator stringCalculator = new StringCalculator();

        //when
        List<String> splitedText = stringCalculator.splitText("1,4:5,a,b:e");

        //then
        assertEquals(splitedText,List.of("1","4","5","a","b","e"));
    }
}

package str_calc;

import org.junit.jupiter.api.BeforeEach;
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

    @Test
    @DisplayName("분리된 문자열들을 유효성 검사 포함하여 숫자로 변환")
    public void validateText() {
        //given
        StringCalculator stringCalculator = new StringCalculator();

        //when, then
        assertEquals(stringCalculator.toInt("1"),1);
        assertEquals(stringCalculator.toInt("0"),0);
        assertEquals(stringCalculator.toInt(""),0);
        assertEquals(stringCalculator.toInt("112"),112);
        assertThrows(RuntimeException.class,()-> stringCalculator.toInt("a"));
        assertThrows(RuntimeException.class,()-> stringCalculator.toInt("-1"));
    }

    @Test
    @DisplayName("텍스트를 Integer List로 반환")
    public void toIntList() {
        //given
        StringCalculator stringCalculator = new StringCalculator();

        //when, then
        assertEquals(stringCalculator.toIntList("1,2:3"), List.of(1,2,3));
        assertThrows(RuntimeException.class,()-> stringCalculator.toIntList("1,2:-3"));
    }
}

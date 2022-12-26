import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringAdditionTest {

    @Test
    @DisplayName("기본 구분자 - 정답")
    void defaultDelimitersValid() {
        String testString = "1,2:3";
        Calculator cal = new Calculator(testString);
        String[] result = del.separate(testString);
        assertArrayEquals(result, new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("커스텀 구분자 분리 - 정답")
    void separateCustomDelimiter() {
        String testString = "//;\n1;2;3,4:5";
        Calculator calc = new Calculator(testString);
    }

}

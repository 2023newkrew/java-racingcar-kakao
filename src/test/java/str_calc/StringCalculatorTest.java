package str_calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class StringCalculatorTest {

    @Test
    @DisplayName("can split text to List based on delimiters")
    public void can_split_text_to_List_based_on_delimiters() {
        StringCalculator stringCalculator = new StringCalculator();
        List<String> splitText = stringCalculator.splitText("1,4:5,a,b:e");
        assertEquals(List.of("1","4","5","a","b","e"), splitText);
    }

    @Test
    @DisplayName("can extract a custom delimiter from text")
    public void can_extract_a_custom_delimiter_from_text() {
        StringCalculator stringCalculator = new StringCalculator();
        String text = stringCalculator.extractDelimiter("//;\n1,2:3;4");
        assertEquals("1,2:3;4", text);
        assertEquals(10, stringCalculator.sum(text));
    }

    @Test
    @DisplayName("can convert String into a positive integer")
    public void can_convert_String_into_a_positive_integer() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.toInt(""));
        assertEquals(0, stringCalculator.toInt("0"));
        assertEquals(123, stringCalculator.toInt("123"));
        assertThrows(RuntimeException.class,()-> stringCalculator.toInt("-1"));
        assertThrows(RuntimeException.class,()-> stringCalculator.toInt("a"));
    }

    @Test
    @DisplayName("can convert text into int List")
    public void can_convert_text_into_int_List() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(List.of(1,2,3), stringCalculator.toIntList("1,2:3"));
    }

    @Test
    @DisplayName("can sum elements of int List")
    public void can_sum_elements_of_int_List() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.sum(List.of(1,2,3)));
    }

    @Test
    @DisplayName("can return sum from text")
    public void sumText() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.sum("1,2:3"));
        assertThrows(RuntimeException.class,()-> stringCalculator.sum("1,2:-3"));
    }
}

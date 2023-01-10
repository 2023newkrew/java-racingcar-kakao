package str_calc.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class IntegerConverterTest {
    @Test
    @DisplayName("can convert text into int List")
    public void can_convert_text_into_int_List() {
        assertEquals(List.of(0, 0, 123), IntegerConverter.toIntList(List.of("", "0", "123")));
    }

    @Test
    @DisplayName("can validate wrong text")
    public void can_validate_wrong_text() {
        assertThrows(RuntimeException.class, () -> IntegerConverter.toIntList(List.of("-1")));
        assertThrows(RuntimeException.class, () -> IntegerConverter.toIntList(List.of("a")));
    }
}

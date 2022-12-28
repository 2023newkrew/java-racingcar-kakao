package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class IOTest {

    @Test
    @DisplayName("can return validated name of length 5")
    public void can_return_validated_name_of_length_5() {
        IO io = new IO();
        String name;

        name = io.validateCarName("oscar");
        assertEquals("oscar", name);

        name = io.validateCarName("gene");
        assertEquals("gene ", name);

        name = io.validateCarName("1234567");
        assertEquals("12345", name);

        name = io.validateCarName("");
        assertEquals("     ", name);
    }

    @Test
    @DisplayName("can parse names from text")
    public void can_parse_names_from_text() {
        IO io = new IO();
        String text = "oscar,gene,,1234567";
        List<String> names = io.parseCarNames(text);
        assertEquals(List.of("oscar", "gene ", "     ", "12345"), names);
    }
}

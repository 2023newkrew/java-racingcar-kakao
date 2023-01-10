package str_calc.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Text;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextParserTest {
    @Test
    @DisplayName("can split text to List based on delimiters")
    public void can_split_text_to_List_based_on_delimiters() {
        TextParser textParser = new TextParser();
        List<String> splitText = textParser.splitText("//;\n1,2:3;4");
        assertEquals(List.of("1", "2", "3", "4"), splitText);
    }
}

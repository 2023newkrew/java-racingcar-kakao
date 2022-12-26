import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringAdderTest {

    private StringAdder stringAdder;

    @BeforeEach
    void setUp(){
        stringAdder = new StringAdder();
    }
    @Test
    public void ifNullReturnZero(){
        String text = null;
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void ifEmptyReturnZero(){
        String text = "";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(0);
    }


    @Test
    public void ifBlankReturnZero(){
        String text = "   ";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(0);
    }


    @Test
    public void ParseIntTest(){
        String text = "2";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(2);
    }
    @Test
    public void ParseAnotherTest(){
        String text = "a";
        assertThatThrownBy(()-> stringAdder.add(text)).isInstanceOf(NumberFormatException.class);
    }
}

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThat(result).isEqualTo(StringAdderConstant.IS_NULL_OR_BLANK);
    }

    @Test
    public void ifEmptyReturnZero(){
        String text = "";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(StringAdderConstant.IS_NULL_OR_BLANK);
    }


    @Test
    public void ifBlankReturnZero(){
        String text = "   ";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(StringAdderConstant.IS_NULL_OR_BLANK);
    }


    @Test
    public void parseIntTest(){
        String text = "2";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(2);
    }
    @Test
    public void parseAnotherTest(){
        String text = "a";
        assertThatThrownBy(()-> stringAdder.add(text)).isInstanceOf(NumberFormatException.class);
    }

    @Test
    public void commaSplitTextTest(){
        String text = "2,5,3";
        String[] numbers = stringAdder.split(text);
        assertThat(numbers).containsExactly("2","5","3");
    }

    @Test
    public void semicolonSplitTextTest(){
        String text = "2;5;3";
        String[] numbers = stringAdder.split(text);
        assertThat(numbers).containsExactly("2","5","3");
    }

    @Test
    public void customDelimiterTest(){
        String text = "//s\n1s2s3";
        String[] numbers = stringAdder.split(text);
        assertThat(numbers).containsExactly("1","2","3");
    }

    @Test
    public void ifNegativeThrowRuntimeException(){
        String text = "-1,2,3";
        String[] numbers = stringAdder.split(text);
        assertThatThrownBy(() -> {
            stringAdder.isValid(numbers);
        }).isInstanceOf(RuntimeException.class);
    }
    @Test
    public void summationTest(){
        String [] numbers = {"1","2","3"};
        String [] numbers2 = {"1","2","3","4"};
        int result = stringAdder.summation(numbers);
        assertThat(result).isEqualTo(6);
        result = stringAdder.summation(numbers2);
        assertThat(result).isEqualTo(10);
    }
    @Test
    public void addTest(){
        String text = "1,0,3";
        int result = stringAdder.add(text);
        assertThat(result).isEqualTo(4);

    }
}

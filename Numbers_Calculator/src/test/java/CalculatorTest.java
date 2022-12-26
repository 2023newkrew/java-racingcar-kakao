import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        this.calculator = new Calculator();
    }

    @Test
    public void stringSplitComma(){
        String origin_str = "0,1,2";
        List<Integer> splitted_numberes = calculator.splitNumbers(origin_str, ",|:");
        Assertions.assertThat(splitted_numberes).isEqualTo(Arrays.asList(0, 1, 2));
    }

    @Test
    public void stringSplitColon(){
        String origin_str = "0:1:2";
        List<Integer> splitted_numberes = calculator.splitNumbers(origin_str, ",|:");
        Assertions.assertThat(splitted_numberes).isEqualTo(Arrays.asList(0, 1, 2));
    }

    @Test
    public void stringSplitClonAndComma(){
        String origin_str = "0,1:2";
        List<Integer> splitted_numberes = calculator.splitNumbers(origin_str, ",|:");
        Assertions.assertThat(splitted_numberes).isEqualTo(Arrays.asList(0, 1, 2));
    }

    @Test
    public void stringEmptyString() {
        String origin_str = "";
        List<Integer> splitted_numberes = calculator.splitNumbers(origin_str, ",|:");
        Assertions.assertThat(splitted_numberes).isEqualTo(Collections.emptyList());
    }

    @Test
    public void sumList(){
        Integer result = calculator.summarizeNumbers("0,1,2", ",|:");
        Assertions.assertThat(result).isEqualTo(3);
    }
}

package com.calc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ExpressionTest {
    @Test
    void checkSeparatorsTest() {
        // "//;\n1;2:3,4"
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        List<Separator> separators = Arrays.asList(new Separator(";"), new Separator(":"), new Separator(","));
        Expression expression = new Expression(values, separators, ";");
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> expression.checkSeparators());
    }
    @Test
    void checkValueTest() {
        // "//;\n1;2:3,-4"
        List<Integer> values = Arrays.asList(1, 2, 3, -4);
        List<Separator> separators = Arrays.asList(new Separator(";"), new Separator(":"), new Separator(","));
        Expression expression = new Expression(values, separators, ";");
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> expression.checkValues());
    }


    @Test
    void sumTest() {
        // "1,2,3,4"
        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        List<Separator> separators = Arrays.asList(new Separator(","), new Separator(","), new Separator(","));
        Expression expression = new Expression(values, separators, "");
        assertThat(expression.sumValues()).isEqualTo(10);
    }
}

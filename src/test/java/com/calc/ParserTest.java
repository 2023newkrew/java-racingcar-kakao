package com.calc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ParserTest {
    @Test
    void parseNullTest(){
        // null, 빈문자열
        Parser parser = new Parser(null);
        Expression expression = parser.parsing();
        assertThat(expression.sumValues()).isEqualTo(0);
    }
    @Test
    void parseEmptyTest(){
        // null, 빈문자열
        Parser parser = new Parser("");
        Expression expression = parser.parsing();
        assertThat(expression.sumValues()).isEqualTo(0);
    }
    @Test
    void parseIntegerTest(){
        // null, 빈문자열
        Parser parser = new Parser("1");
        Expression expression = parser.parsing();
        assertThat(expression.sumValues()).isEqualTo(1);
    }
    @Test
    void parseMultiIntegerTest(){
        // null, 빈문자열
        Parser parser = new Parser("1,2");
        Expression expression = parser.parsing();
        assertThat(expression.sumValues()).isEqualTo(3);
    }
    @Test
    void parseMultiSepTest(){
        // null, 빈문자열
        Parser parser = new Parser("1,2:3");
        Expression expression = parser.parsing();
        assertThat(expression.sumValues()).isEqualTo(6);
    }
    @Test
    void parseHeaderTest(){
        // null, 빈문자열
        Parser parser = new Parser("//;\n1;2");
        Expression expression = parser.parsing();
        assertThat(expression.sumValues()).isEqualTo(3);
    }
}

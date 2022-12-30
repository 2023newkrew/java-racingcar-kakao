package com.calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

public class CalcTest {

    @DisplayName("올바른 파싱 케이스")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "'1'            | 1",
            "'1,2'          | 3",
            "'1:2'          | 3",
            "'//;\n1,2'     | 3",
            "'//;\n1:2'     | 3",
            "'//;\n1;2'     | 3",
    })
    void validParseTest(String sourceText, int expectValue) {
        var temp = Calc.parse(sourceText);
        assertThat(temp.calculate()).isEqualTo(expectValue);
    }


    @DisplayName("올바르지 않은 파싱 케이스")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "               | ", // null
            "''             | ", // empty
            "'1;2'          | ", // 선언하지 않은 구분자
            "'//;\n1+2'     | ", // 선언하지 않은 구분자
    })
    void invalidParseTest(String sourceText) {
        assertThatException()
                .isThrownBy(() -> Calc.parse(sourceText));
    }
}

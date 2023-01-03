package com.calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

public class CustomSeparatorTest {
    @DisplayName("올바른 파싱 케이스")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "'//;\n1;2'     | 3         | ''",
            "'//;\n1;2ab'   | 3         | 'ab'",
    })
    void validParseTest(String sourceText, int expectValue, String remainText) {
        var temp = CustomSeparator.parse(new LanguageContext(), sourceText);
        assertThat(temp.getKey()
                .calculate()).isEqualTo(expectValue);
        assertThat(temp.getValue()).isEqualTo(remainText);
    }


    @DisplayName("올바르지 않은 파싱 케이스")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "               | ", // null
            "''             | ", // empty
            "'//;\n1+2'     | ", // 선언하지 않은 구분자
    })
    void invalidParseTest(String sourceText) {
        assertThatException()
                .isThrownBy(() -> PositiveInteger.parse(new LanguageContext(), sourceText));
    }
}

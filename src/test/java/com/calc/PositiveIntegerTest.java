package com.calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

public class PositiveIntegerTest {


    @DisplayName("생성자, 계산 메서드 검증")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "1  |",
            "2  |",
            "3  |",
    })
    void validCalculateTest(int sourceValue) {
        assertThat(new PositiveInteger(sourceValue).calculate())
                .isEqualTo(sourceValue);
    }

    @DisplayName("올바른 파싱 케이스")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "'1'            | 1         | ''",
            "'1234'         | 1234      | ''",
            "'1234,1234'    | 1234      | ',1234'",
    })
    void validParseTest(String sourceText, int expectValue, String remainText) {
        var temp = PositiveInteger.parse(new LanguageContext(), sourceText);
        assertThat(temp.getKey()
                .calculate()).isEqualTo(expectValue);
        assertThat(temp.getValue()).isEqualTo(remainText);
    }


    @DisplayName("올바르지 않은 파싱 케이스")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "               | ",
            "''             | ",
            "'a'            | ",
    })
    void invalidParseTest(String sourceText) {
        assertThatException()
                .isThrownBy(() -> PositiveInteger.parse(new LanguageContext(), sourceText));
    }
}

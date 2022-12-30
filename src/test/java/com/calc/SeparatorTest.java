package com.calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

public class SeparatorTest {


    @DisplayName("생성자, 계산 메서드 검증")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "1 | ',' | 2 | 3",
    })
    void validCalculateTest(int leftValue, char separator, int rightValue, int expectedValue) {
        assertThat(new Separator(
                new PositiveInteger(leftValue),
                separator,
                new PositiveInteger(rightValue)
        ).calculate())
                .isEqualTo(expectedValue);
    }

    @DisplayName("올바른 파싱 케이스")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "'.' | '1,2'              | 3 ",
            "'.' | '1,2,3'            | 6 ",
            "'.' | '1,2,3,4'          | 10 ",
            "'.' | '1:2'              | 3 ",
            "'.' | '1:2:3'            | 6 ",
            "'.' | '1:2:3:4'          | 10 ",
            "'.' | '1.2'              | 3 ",
            "'.' | '1.2.3'            | 6 ",
            "'.' | '1.2.3.4'          | 10 ",
    })
    void validParseTest(Character customSep, String sourceText, int expectValue) {
        var temp = Separator.parse(new LanguageContext(List.of(customSep)), sourceText);
        assertThat(temp.getKey()
                .calculate()).isEqualTo(expectValue);
//        assertThat(temp.getValue()).isEqualTo(remainText);
    }


    @DisplayName("올바르지 않은 파싱 케이스")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "               | ",
            "''             | ",
            "'1'            | ",
            "',1,2'         | ",
            "'1;2'          | ", // 정의하지 않은 커스텀 구분자
    })
    void invalidParseTest(String sourceText) {
        assertThatException()
                .isThrownBy(() -> Separator.parse(new LanguageContext(), sourceText));
    }
}

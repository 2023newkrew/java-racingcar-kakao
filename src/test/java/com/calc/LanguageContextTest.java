package com.calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LanguageContextTest {


    @DisplayName("생성자, 계산 메서드 검증")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "''         | ','       | true",
            "''         | ':'       | true",
            "''         | ';'       | false",
            "';'        | ','       | true",
            "';'        | ':'       | true",
            "';'        | ';'       | true",
    })
    void validCalculateTest(String customSeparators, String testSeparator, boolean expectedValue) {
        var temp = customSeparators.chars()
                .mapToObj(v -> (char) v)
                .collect(Collectors.toList());
        assertThat(new LanguageContext(temp).isAllowedSeparator(testSeparator.charAt(0)))
                .isEqualTo(expectedValue);
    }

}

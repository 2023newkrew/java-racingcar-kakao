package com.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    // 차 이름이 5글자 이하인지에 대한 테스트
    @DisplayName("올바르지 않은 이름이 주어졌을 때")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef"})
    void invalidNameTest(String invalidName) {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> Car.factory()
                        .withName(invalidName)
                        .build()
                );
    }

    @DisplayName("올바른 이름이 주어졌을 때")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void validNameTest(String validName) {
        Car car = Car.factory()
                .withName(validName)
                .build();
        assertThat(car.name()).isEqualTo(validName);
    }

    @DisplayName("올바른 범위의 값이 move로 주어졌을 때")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "0 | 0",
            "1 | 0",
            "2 | 0",
            "3 | 0",
            "4 | 1",
            "5 | 1",
            "6 | 1",
            "7 | 1",
            "8 | 1",
            "9 | 1",
    })
    void validMoveTest(int userIn, int expectLocation) {
        Car car = Car.factory()
                .withName("a")
                .build();
        car.move(userIn);
        assertThat(car.location()).isEqualTo(expectLocation);
    }

    @DisplayName("올바르지 않은 범위의 값이 move로 주어졌을 때")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 10, Integer.MAX_VALUE})
    void invalidMoveTest(int userIn) {
        Car car = Car.factory()
                .withName("a")
                .build();
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> car.move(userIn));
    }

//    @Test
//    void moveNotBoundedTest(){
//        Car car1 = new Car("car1");
//        // move 의 입력값은 0 ~ 9 사이여야 한다.
//        assertThatExceptionOfType(RuntimeException.class)
//                .isThrownBy(()-> car1.move(-1));
//    }
//
//    // 차의 현재 location 출력 테스트
//    @Test
//    void printLocationTest(){
//        Car car1 = new Car("car1");
//        assertThat(car1.formatLocation()).isEqualTo("car1 : ");
//        // 한 칸 이동
//        car1.move(9);
//        assertThat(car1.formatLocation()).isEqualTo("car1 : -");
//    }
}

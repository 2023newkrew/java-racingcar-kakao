package com.racing;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    // 차 이름이 5글자 이하인지에 대한 테스트
    @Test
    void checkNameTest(){
        Car car = new Car("carName");

        // RuntimeException 발생 시 종료
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> car.checkName());
    }
}

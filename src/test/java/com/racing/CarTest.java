package com.racing;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void movementTest(){
        Car car1 = new Car("car1");
        // 기본 상태 0이여야 함
        assertThat(car1.location).isEqualTo(0);
        // 이동하지 못함(사유 : 입력이 0 임) 위치는 0임
        car1.movement(0);
        assertThat(car1.location).isEqualTo(0);
        // 이동하지 못함(사유 : 입력이 3 임) 위치는 0임
        car1.movement(3);
        assertThat(car1.location).isEqualTo(0);
        // 1만큼 이동함(사유 : 입력이 4 임) 위치는 1임
        car1.movement(4);
        assertThat(car1.location).isEqualTo(1);
    }
}

package racing_car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.model.Car;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    /*
    # Car 클래스가 갖춰야 할 요소
    - 전진할수 있다. -> 위치를 가지고 있음.
    - 4 이상의 값이면 전진, 3 이하의 값이면 멈춤
    - 이름을 부여하여 생성할수 있다. -> 이름을 가지고 있음.
    - 이름은 5자 이하만 가능하다.
    */

    @Test
    @DisplayName("이름을 부여하여 생성")
    void createWithName() {
        Car car = new Car("pobi");
        assertThat(car.name()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("이름은 한글자 이상")
    void emptyName() {
        Car car = new Car("");
        assertThatThrownBy(()->new Car(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름의 길이가 너무 적습니다.");
    }

    @Test
    @DisplayName("차량 전진")
    void proceed(){
        Car car = new Car("pobi");
        int start = car.distance();
        car.proceed(5);
        assertThat(car.distance()).isEqualTo(start + 1);
    }

}

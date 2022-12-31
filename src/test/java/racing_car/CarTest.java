package racing_car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing_car.model.Car;
import racing_car.model.Cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CarTest {

    @Test
    @DisplayName("이름이 빈 문자열일 경우 테스트")
    void checkEmptyName() {
        String testName = "";
        Throwable t = assertThrowsExactly(IllegalArgumentException.class, () -> Cars.of(testName.split(",")));
        assertEquals(t.getMessage(), "이름은 1자 이상이여야 합니다.");
    }

    @Test
    @DisplayName("이름이 5자 초과일 경우 테스트")
    void checkNameMaxLength() {
        String testName = "chunsik";
        Throwable t = assertThrowsExactly(IllegalArgumentException.class, () -> Cars.of(testName.split(",")));
        assertEquals(t.getMessage(), "이름은 5자 이하여야 합니다.");
    }

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    @DisplayName("차량 전진 제어")
    void carControl(int step) {
        Car car = new Car("pobi");
        car.move(step);

        String output = "-".repeat(car.getDistance());
        assertEquals("-".repeat(step), output);
    }

    @Test
    @DisplayName("차량간 거리 비교")
    void compareCars() {
        Car a = new Car("pobi");
        Car b = new Car("crong");

        a.move(4);
        b.move(2);

        assertEquals(-1, b.compareTo(a));
    }
}

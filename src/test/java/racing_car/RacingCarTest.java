package racing_car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing_car.model.Car;
import racing_car.model.Cars;
import racing_car.model.Game;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    private static Cars separateCarNamesByDelimiter(String target) {

        return Cars.of(target.split(","));
    }

    @Test
    @DisplayName("제공된 문자열로 자동차 배열 생성")
    void separateByDelimiter() {
        String testNames = "pobi,crong,honux";
        Cars cars = separateCarNamesByDelimiter(testNames);
        assertEquals(cars, Cars.of(new Car[]{
                new Car("pobi"),
                new Car("crong"),
                new Car("honux")
        }));
    }

    @Test
    @DisplayName("이름이 빈 문자열일 경우 테스트")
    void checkEmptyName() {
        String testName = "";
        Throwable t = assertThrowsExactly(IllegalArgumentException.class, () -> separateCarNamesByDelimiter(testName));
        assertEquals(t.getMessage(), "이름은 1자 이상이여야 합니다.");
    }

    @Test
    @DisplayName("이름이 5자 초과일 경우 테스트")
    void checkNameMaxLength() {
        String testName = "chunsik";
        Throwable t = assertThrowsExactly(IllegalArgumentException.class, () -> separateCarNamesByDelimiter(testName));
        assertEquals(t.getMessage(), "이름은 5자 이하여야 합니다.");
    }

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    @DisplayName("차량 전진 제어")
    void carControl(int step) {
        Car car = new Car("pobi");
        car.move(step);

        String output = car.displayDistance();
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

    @Test
    @DisplayName("우승자 구하기")
    void getWinners() {
        String[] testNames = {"pobi", "crong", "honux", "ryan", "chun", "jordy"};
        Car[] cars = new Car[testNames.length];

        int[] distances = new int[]{1, 5, 2, 5, 4, 5};
        for (int i = 0; i < distances.length; i++) {
            cars[i] = new Car(testNames[i]);
            cars[i].move(distances[i]);
        }

        Cars cars1 = Cars.of(cars);

        assertEquals(Cars.of(new Car[]{
                cars[1], cars[3], cars[5]
        }), cars1.getWinners());
    }
}

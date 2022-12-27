import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.model.Car;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("제공된 문자열로 자동차 배열 생성")
    void separateByComma() {
        String testNames = "pobi,crong,honux";
        Car[] cars = Car.from(testNames);
        assertArrayEquals(cars, new Car[] {
                new Car("pobi"),
                new Car("crong"),
                new Car("honux")
        });
    }
}

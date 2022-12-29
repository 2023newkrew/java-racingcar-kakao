package racing_car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.model.Car;
import racing_car.model.Cars;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {

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

    private static Cars separateCarNamesByDelimiter(String target) {

        return Cars.of(target.split(","));
    }
}

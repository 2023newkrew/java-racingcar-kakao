package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {
    @Test
    void createCars() {
        String names = "crong,honux,pobi";
        Car[] cars = Main.namesToCars(names);
        assertThat(cars).isEqualTo(new Car[]{
                new Car("crong"),
                new Car("honux"),
                new Car("pobi"),
        });
    }
}

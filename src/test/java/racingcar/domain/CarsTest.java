package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.factory.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void getMaxPositionTest() {
        Car car1 = CarFactory.createCar("pobi", 2);
        Car car2 = CarFactory.createCar("crong", 3);
        Car car3 = CarFactory.createCar("honux", 2);

        Cars cars = new Cars(List.of(car1, car2, car3));

        assertThat(cars.getMaxPosition()).isEqualTo(3);
    }

    @Test
    void getSingleWinnerTest() {
        Car car1 = CarFactory.createCar("pobi", 2);
        Car car2 = CarFactory.createCar("crong", 3);
        Car car3 = CarFactory.createCar("honux", 2);

        Cars cars = new Cars(List.of(car1, car2, car3));

        assertThat(cars.getWinner()
                .size()).isEqualTo(1);
        assertThat(cars.getWinner()).isEqualTo(List.of(car2));
    }

    @Test
    void getMultipleWinnerTest() {
        Car car1 = CarFactory.createCar("pobi", 2);
        Car car2 = CarFactory.createCar("crong", 3);
        Car car3 = CarFactory.createCar("honux", 3);

        Cars cars = new Cars(List.of(car1, car2, car3));

        assertThat(cars.getWinner()
                .size()).isEqualTo(2);
        assertThat(cars.getWinner()).isEqualTo(List.of(car2, car3));
    }

    @Test
    void getEachCarsResultsTest() {
        Car car1 = CarFactory.createCar("pobi",0);
        Car car2 = CarFactory.createCar("crong",4);

        Cars cars = new Cars(List.of(car1, car2));

        assertThat(cars.getEachCarResults()).containsExactly("pobi : ", "crong : ----");
    }
}

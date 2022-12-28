package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racing.dto.CarDTO;
import racing.dto.CarDtoDistanceComparator;

public class CarTest {
    private Car car;
    private CarDTO carDTO;

    @RepeatedTest(100)
    void moveFalseTest() {
        car = new Car("123", () -> false);
        car.move();
        assertThat(CarDTO.from(car).getDistance()).isEqualTo(0);
    }

    @RepeatedTest(100)
    void moveTrueTest() {
        car = new Car("123", () -> true);
        car.move();
        assertThat(CarDTO.from(car).getDistance()).isEqualTo(1);
    }

    @Test
    void compareDistanceTest() {
        carDTO = new CarDTO("12324", 1);
        CarDtoDistanceComparator distanceComparator = new CarDtoDistanceComparator();
        CarDTO opponentCarDTO = new CarDTO("123", 1);
        assertThat(distanceComparator.compare(opponentCarDTO, carDTO)).isEqualTo(0);

        opponentCarDTO = new CarDTO("123", 3);
        assertThat(distanceComparator.compare(opponentCarDTO, carDTO)).isGreaterThan(0);
        assertThat(distanceComparator.compare(carDTO, opponentCarDTO)).isLessThan(0);
    }
}

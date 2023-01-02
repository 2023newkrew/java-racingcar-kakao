package carracing;

import carracing.domain.Car;
import carracing.domain.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class CarsTest {

    @DisplayName("maxPosition이 cars의 목록 중 최대 포지션인 3을 반환")
    @Test
    void getMaxPositionTest() {
        //given
        Cars cars = new Cars(List.of(
                new Car("a", 3), new Car("b", 1)
        ));
        //when
        int maxPosition = cars.getMaxPosition();
        //then
        Assertions.assertThat(maxPosition).isEqualTo(3);
    }

    @DisplayName("포지션이 3인 car의 수가 2개임을 확인")
    @Test
    void getCarsInPositionTest() {
        //given
        Cars cars = new Cars(List.of(
                new Car("a", 3), new Car("b", 3), new Car("c", 1)
        ));
        //when
        List<Car> carsInPosition = cars.getCarsInPosition(3);
        //then
        Assertions.assertThat(carsInPosition).hasSize(2);
    }
}
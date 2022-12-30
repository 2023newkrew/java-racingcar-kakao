package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.CarList;
import racing.domain.Racing;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private Racing racing;
    private CarList cars;

    @BeforeEach
    void setUp() {
        racing = new Racing();
        cars = new CarList("pobi,crong,honux");
//        cars = racing.createCars("pobi,crong,honux");
    }

    @DisplayName("이름 입력을 통해 변환한 자동차 배열의 길이가 유지되었는지 테스트")
    @Test
    public void createCarsTest() {
        assertThat(cars.getCars().length).isEqualTo(3);
    }

    @DisplayName("정지/전진을 한 번 마친 자동차 배열의 길이가 유지되었는지 테스트")
    @Test
    public void oneCycleTest() {
        cars = racing.oneCycle(cars);
        assertThat(cars.getCars().length).isEqualTo(3);
    }

}

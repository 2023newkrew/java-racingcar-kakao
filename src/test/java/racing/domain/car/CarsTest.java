package racing.domain.car;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.car.Car;
import racing.domain.car.Cars;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarsTest {
    private Cars cars;
    @BeforeEach
    public void setUp() {
        cars = new Cars();
    }

    @ParameterizedTest
    @DisplayName("숫자가 4 이상이면 이동할 수 있다.")
    @CsvSource(value = {"4:true", "9:true"}, delimiter = ':')
    public void isMove(int input, boolean expected) {
        cars = new Cars();
        assertThat(cars.isMovable(input)).isEqualTo(expected);
        assertThat(cars.isMovable(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자가 4 미만이면 이동할 수 없다.")
    @CsvSource(value = {"0:false", "3:false"}, delimiter = ':')
    public void isStop(int input, boolean expected) {
        assertThat(cars.isMovable(input)).isEqualTo(expected);
        assertThat(cars.isMovable(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getMaxPositionArgument")
    @DisplayName("가장 높은 포지션을 갖는 자동차를 가져온다.")
    public void getMaxPositionCar(Cars cars, Car expected) {
        assertThat(cars.getCarWithMaxPosition())
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("같은 포지션을 가진 자동차들의 이름 리스트를 가져온다.")
    public void getSamePositionCar() {
        Car car1 = new Car("mon", 1);
        Car car2 = new Car("tue", 2);
        Car car3 = new Car("wed", 1);

        cars = new Cars(Arrays.asList(car1, car2, car3));
        assertThat(cars.getNamesWithSamePosition(car1))
            .containsExactly(
                car1.getName(),
                car3.getName()
        );
    }

    static Stream<Arguments> getMaxPositionArgument() {
        Car car1 = new Car("mon", 1);
        Car car2 = new Car("tue", 2);
        Car car3 = new Car("wed", 3);
        Car car4 = new Car("thu", 4);
        Car car5 = new Car("fri", 5);

        return Stream.of(
                Arguments.arguments(new Cars(Arrays.asList(car1, car3)), car3),
                Arguments.arguments(new Cars(Arrays.asList(car5, car4)), car5),
                Arguments.arguments(new Cars(Arrays.asList(car1, car2)), car2),
                Arguments.arguments(new Cars(Arrays.asList(car3, car1, car2)), car3),
                Arguments.arguments(new Cars(Arrays.asList(car2, car4, car3)), car4)
        );
    }
}

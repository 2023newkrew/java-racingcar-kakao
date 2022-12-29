package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

public class MoveCarTest {

    @Test
    public void oneCarCanMove() {
        Car car = new Car();
        boolean canMove = car.canMove(4);
        car.moveOne(canMove);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @RepeatedTest(10)
    public void multiCarsMove(){
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        Cars cars = new Cars(carNames);
        cars.move();
        for (Car car: cars.getCarList()){
            Assertions.assertThat(car.getPosition()).isBetween(0, 1);
        }
    }
}




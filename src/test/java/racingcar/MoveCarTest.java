package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.RacingGameRunner;

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
        String carNames = "Car1,Car2,Car3";
        RacingGameRunner racingGameRunner = new RacingGameRunner();
        racingGameRunner.registeredData(carNames, 0);
        racingGameRunner.move();
        for (Car car: racingGameRunner.getCarList()){
            Assertions.assertThat(car.getPosition()).isBetween(0, 1);
        }
    }
}




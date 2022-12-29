package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.model.strategy.MovableStrategy;

public class MovableStrategyTest {

    @RepeatedTest(10)
    public void createRandomTest(){
        MovableStrategy movableStrategy = new MovableStrategy();
        Integer randomNumber = movableStrategy.generateRandomNumber();
        Assertions.assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    public void moveIfNumberGreaterOrEqualThan4() {
        MovableStrategy movableStrategy = new MovableStrategy();
        int number = 4;
        boolean result = movableStrategy.canMove(number);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void notMoveIfNumberGreaterOrEqualThan4() {
        MovableStrategy movableStrategy = new MovableStrategy();
        int number = 3;
        boolean result = movableStrategy.canMove(number);
        Assertions.assertThat(result).isFalse();
    }
}

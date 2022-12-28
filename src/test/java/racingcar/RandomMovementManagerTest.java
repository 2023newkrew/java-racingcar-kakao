package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovementManagerTest {

    @Test
    void makeMovementDecision_true(){
        // given
        RandomMovementManager randomMovementManager = new RandomMovementManager((bound) -> 8);

        // when
        boolean isMove = randomMovementManager.makeMovementDecision(); //true

        // then
        assertThat(isMove).isTrue();
    }

    @Test
    void makeMovementDecision_false(){
        // given
        RandomMovementManager randomMovementManager = new RandomMovementManager((bound) -> 3);

        // when
        boolean isMove = randomMovementManager.makeMovementDecision(); //false

        // then
        assertThat(isMove).isFalse();
    }
}

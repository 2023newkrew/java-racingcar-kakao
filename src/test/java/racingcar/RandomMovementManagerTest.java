package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovementManagerTest {

    @DisplayName("랜덤값이 4 이상일 경우 true를 반환한다")
    @Test
    void makeMovementDecision_true(){
        // given
        RandomMovementManager randomMovementManager = new RandomMovementManager((bound) -> 8);

        // when
        boolean isMove = randomMovementManager.makeMovementDecision(); //true

        // then
        assertThat(isMove).isTrue();
    }

    @DisplayName("랜덤값이 4 미만일 경우 false를 반환한다")
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

package CarRacing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomValueMovingStrategyTest {
    @DisplayName("랜덤 값에 따른 전진 테스트")
    @Test
    public void isMovableTest() {
        RandomValueMovingStrategy randomValueMovingStrategy = new RandomValueMovingStrategy(range -> 4);
        assertThat(randomValueMovingStrategy.movable()).isEqualTo(true);
    }

    @DisplayName("랜덤 값에 따른 비전진 테스트")
    @Test
    public void isNotMovableTest() {
        RandomValueMovingStrategy randomValueMovingStrategy = new RandomValueMovingStrategy(range -> 3);
        assertThat(randomValueMovingStrategy.movable()).isEqualTo(false);
    }

}

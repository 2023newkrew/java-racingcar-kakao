package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("name");
    }

    @DisplayName("move(true)일 경우 distance가 1 증가한다")
    @Test
    void moveTest_move(){
        // given
        int prevDist = racingCar.getDistance();

        // when
        racingCar.move(true);
        int curDist = racingCar.getDistance();

        // then
        assertThat(curDist).isEqualTo(prevDist + 1);
    }

    @DisplayName("move(false)일 경우 distance가 증가하지 않는다")
    @Test
    void moveTest_stop(){
        // given
        int prevDist = racingCar.getDistance();

        // when
        racingCar.move(false);
        int curDist = racingCar.getDistance();

        // then
        assertThat(curDist).isEqualTo(prevDist);
    }
}

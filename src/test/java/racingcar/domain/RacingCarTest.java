package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void moveTest_move(){
        // given
        RacingCar racingCar = new RacingCar("name");
        String prevStatus = racingCar.toString();

        // when
        racingCar.move(true);
        String curStatus = racingCar.toString();

        // then
        assertThat(prevStatus + '-').isEqualTo(curStatus);
    }

    @Test
    void moveTest_stop(){
        // given
        RacingCar racingCar = new RacingCar("name");
        String prevStatus = racingCar.toString();

        // when
        racingCar.move(false);
        String curStatus = racingCar.toString();

        // then
        assertThat(prevStatus).isEqualTo(curStatus);
    }
}
